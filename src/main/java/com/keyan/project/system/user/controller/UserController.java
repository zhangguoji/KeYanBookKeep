package com.keyan.project.system.user.controller;

import com.keyan.common.utils.CommonUtils;
import com.keyan.common.utils.StringUtils;
import com.keyan.common.utils.poi.ExcelUtil;
import com.keyan.framework.aspectj.lang.annotation.Log;
import com.keyan.framework.aspectj.lang.constant.BusinessType;
import com.keyan.framework.web.controller.BaseController;
import com.keyan.framework.web.domain.AjaxResult;
import com.keyan.framework.web.page.TableDataInfo;
import com.keyan.project.system.dept.domain.Dept;
import com.keyan.project.system.dept.service.IDeptService;
import com.keyan.project.system.post.domain.Post;
import com.keyan.project.system.post.service.IPostService;
import com.keyan.project.system.role.domain.Role;
import com.keyan.project.system.role.service.IRoleService;
import com.keyan.project.system.user.domain.ImportUser;
import com.keyan.project.system.user.domain.User;
import com.keyan.project.system.user.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
    private String prefix = "system/user";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;

    @Autowired
    private IDeptService deptService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(User user) {
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", action = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(User user) throws Exception {
        try {
            List<User> list = userService.selectUserList(user);
            ExcelUtil<User> util = new ExcelUtil<User>(User.class);
            return util.exportExcel(list, "user");
        } catch (Exception e) {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }

    /**
     * 修改用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", action = BusinessType.UPDATE)
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, Model model) {
        User user = userService.selectUserById(userId);
        List<Role> roles = roleService.selectRolesByUserId(userId);
        List<Post> posts = postService.selectPostsByUserId(userId);
        model.addAttribute("roles", roles);
        model.addAttribute("posts", posts);
        model.addAttribute("user", user);
        return prefix + "/edit";
    }

    /**
     * 新增用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户管理", action = BusinessType.INSERT)
    @GetMapping("/add")
    public String add(Model model) {
        List<Role> roles = roleService.selectRoleAll();
        List<Post> posts = postService.selectPostAll();
        model.addAttribute("roles", roles);
        model.addAttribute("posts", posts);
        return prefix + "/add";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", action = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, Model model) {
        User user = userService.selectUserById(userId);
        model.addAttribute("user", user);
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", action = BusinessType.SAVE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(User user) {
        int rows = userService.resetUserPwd(user);
        if (rows > 0) {
            return success();
        }
        return error();
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            userService.deleteUserByIds(ids);
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 保存用户
     */
    @RequiresPermissions("system:user:save")
    @Log(title = "用户管理", action = BusinessType.SAVE)
    @PostMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult save(User user) {
        if (StringUtils.isNotNull(user.getUserId()) && User.isAdmin(user.getUserId())) {
            return error("不允许修改超级管理员用户");
        }
        return userService.saveUser(user) > 0 ? success() : error();
    }

    @Log(title = "用户导入", action = BusinessType.INSERT)
    @GetMapping("/import")
    public String import_Excel() {
        return prefix + "/importExcel";
    }

    @Log(title = "数据导入", action = BusinessType.INSERT)
    @PostMapping("/importExcel")
    @ResponseBody
    public AjaxResult importExcel(@RequestParam("excel") MultipartFile multipartFile) {
        InputStream inputStream = null;
        try{
            inputStream = multipartFile.getInputStream();
            List<ImportUser> importUsers = new ArrayList<ImportUser>();
            if(inputStream != null){
                ExcelUtil<ImportUser> util = new ExcelUtil<ImportUser>(ImportUser.class);
                importUsers = util.importExcel("",inputStream);
            }
            if(importUsers.size()>0){
                int sl = 0;
                for (ImportUser importUser:importUsers) {
                    User user = new User();
                    CommonUtils.toBean(importUser,user);
                    //部门转换
                    Dept dept = deptService.selectDeptByName(importUser.getDeptName());
                    user.setDeptId(dept.getDeptId());
                    //职务转换
                    Post post = postService.selectPostByName(importUser.getSlot());
                    Long[] postIds = {post.getPostId()};
                    user.setPostIds(postIds);
                    //默认密码为登录名
                    user.setPassword(importUser.getLoginName());
                    //默认角色为普通用户
                    Long[] roleIds = {Long.parseLong("2")};
                    user.setRoleIds(roleIds);
                    sl = userService.saveUser(user);
                }
            }
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(User user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = userService.checkLoginNameUnique(user.getLoginName());
        }
        return uniqueFlag;
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(User user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = userService.checkPhoneUnique(user);
        }
        return uniqueFlag;
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(User user) {
        String uniqueFlag = "0";
        if (user != null) {
            uniqueFlag = userService.checkEmailUnique(user);
        }
        return uniqueFlag;
    }
}