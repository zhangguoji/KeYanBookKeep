package com.keyan.project.tool.gen.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.keyan.framework.aspectj.lang.annotation.Log;
import com.keyan.framework.aspectj.lang.constant.BusinessType;
import com.keyan.framework.web.controller.BaseController;
import com.keyan.framework.web.page.TableDataInfo;
import com.keyan.project.tool.gen.domain.TableInfo;
import com.keyan.project.tool.gen.service.IGenService;

/**
 * 代码生成 操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/tool/gen")
public class GenController extends BaseController
{
    private String prefix = "tool/gen";

    @Autowired
    private IGenService genService;

    @RequiresPermissions("tool:gen:view")
    @GetMapping()
    public String gen()
    {
        return prefix + "/gen";
    }

    @RequiresPermissions("tool:gen:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TableInfo tableInfo)
    {
        startPage();
        List<TableInfo> list = genService.selectTableList(tableInfo);
        return getDataTable(list);
    }

    /**
     * 生成代码
     */
    @RequiresPermissions("tool:gen:code")
    @Log(title = "代码生成", action = BusinessType.GENCODE)
    @GetMapping("/genCode/{tableName}")
    public void genCode(HttpServletResponse response, @PathVariable("tableName") String tableName) throws IOException
    {
        byte[] data = genService.generatorCode(tableName);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }

    /**
     * 批量生成代码
     */
    @RequiresPermissions("tool:gen:code")
    @Log(title = "代码生成", action = BusinessType.GENCODE)
    @GetMapping("/batchGenCode")
    @ResponseBody
    public void batchGenCode(HttpServletResponse response, String tables) throws IOException
    {
        String[] tableNames = new String[] {};
        tableNames = JSON.parseArray(tables).toArray(tableNames);
        byte[] data = genService.generatorCode(tableNames);
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"ruoyi.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}