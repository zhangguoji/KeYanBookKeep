package com.keyan.project.system.user.domain;

import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

import com.keyan.framework.aspectj.lang.annotation.Excel;
import com.keyan.framework.web.domain.BaseEntity;
import com.keyan.project.system.dept.domain.Dept;

/**
 * 用户对象 sys_user
 *
 * @author ruoyi
 */
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Excel(name = "用户序号", column = "A")
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门父ID
     */
    private Long parentId;

    /**
     * 登录名称
     */
    @Excel(name = "登录名称", column = "B")
    private String loginName;

    /**
     * 用户名称
     */
    @Excel(name = "用户名称", column = "C")
    private String userName;

    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱", column = "D")
    private String email;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码", column = "E")
    private String phonenumber;

    /**
     * 用户性别
     */
    @Excel(name = "用户性别", column = "F")
    private String sex;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    @Excel(name = "帐号状态", column = "G")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登陆IP
     */
    @Excel(name = "最后登陆IP", column = "H")
    private String loginIp;

    /**
     * 最后登陆时间
     */
    @Excel(name = "最后登陆时间", column = "I")
    private Date loginDate;

    /**
     * 固定电话
     */
    @Excel(name = "固定电话", column = "J")
    private String telephone;
    /**
     * 传真
     */
    @Excel(name = "传真", column = "K")
    private String fax;
    /**
     * 邮编
     */
    @Excel(name = "邮编", column = "L")
    private String postalcode;
    /**
     * 办公地址
     */
    @Excel(name = "办公地址", column = "M")
    private String officeaddress;


    /**
     * 部门对象
     */
    private Dept dept;

    /**
     * 角色组
     */
    private Long[] roleIds;

    /**
     * 岗位组
     */
    private Long[] postIds;
    //生日
    private Date birthday;
    //员工职级
    private String rank;
    //基本工资
    private String basicpay;
    //技能补贴
    private String skillssubsidy;
    //职务补贴
    private String jobsubsidy;
    //午餐补贴
    private String lunchsubsidy;
    //地域补贴
    private String geographicalsubsidy;
    //浮动工资
    private String fluctuatingwages;
    //异地补贴
    private String differentplacesubsidy;
    //通话补贴
    private String Telephonesubsidy;
    //自备电脑补贴
    private String computersubsidy;
    //财务证书补贴
    private String financialsubsidy;
    //是否试用
    private String pilot;
    //是否转正
    private String turnpositive;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getBasicpay() {
        return basicpay;
    }

    public void setBasicpay(String basicpay) {
        this.basicpay = basicpay;
    }

    public String getSkillssubsidy() {
        return skillssubsidy;
    }

    public void setSkillssubsidy(String skillssubsidy) {
        this.skillssubsidy = skillssubsidy;
    }

    public String getJobsubsidy() {
        return jobsubsidy;
    }

    public void setJobsubsidy(String jobsubsidy) {
        this.jobsubsidy = jobsubsidy;
    }

    public String getLunchsubsidy() {
        return lunchsubsidy;
    }

    public void setLunchsubsidy(String lunchsubsidy) {
        this.lunchsubsidy = lunchsubsidy;
    }

    public String getGeographicalsubsidy() {
        return geographicalsubsidy;
    }

    public void setGeographicalsubsidy(String geographicalsubsidy) {
        this.geographicalsubsidy = geographicalsubsidy;
    }

    public String getFluctuatingwages() {
        return fluctuatingwages;
    }

    public void setFluctuatingwages(String fluctuatingwages) {
        this.fluctuatingwages = fluctuatingwages;
    }

    public String getDifferentplacesubsidy() {
        return differentplacesubsidy;
    }

    public void setDifferentplacesubsidy(String differentplacesubsidy) {
        this.differentplacesubsidy = differentplacesubsidy;
    }

    public String getTelephonesubsidy() {
        return Telephonesubsidy;
    }

    public void setTelephonesubsidy(String telephonesubsidy) {
        Telephonesubsidy = telephonesubsidy;
    }

    public String getComputersubsidy() {
        return computersubsidy;
    }

    public void setComputersubsidy(String computersubsidy) {
        this.computersubsidy = computersubsidy;
    }

    public String getFinancialsubsidy() {
        return financialsubsidy;
    }

    public void setFinancialsubsidy(String financialsubsidy) {
        this.financialsubsidy = financialsubsidy;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public String getTurnpositive() {
        return turnpositive;
    }

    public void setTurnpositive(String turnpositive) {
        this.turnpositive = turnpositive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(Long userId) {
        return userId != null && 1L == userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 生成随机盐
     */
    public void randomSalt() {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        setSalt(hex);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getOfficeaddress() {
        return officeaddress;
    }

    public void setOfficeaddress(String officeaddress) {
        this.officeaddress = officeaddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", parentId=" + parentId +
                ", loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", sex='" + sex + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", officeaddress='" + officeaddress + '\'' +
                ", dept=" + dept +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", postIds=" + Arrays.toString(postIds) +
                ", birthday=" + birthday +
                ", rank='" + rank + '\'' +
                ", basicpay='" + basicpay + '\'' +
                ", skillssubsidy='" + skillssubsidy + '\'' +
                ", jobsubsidy='" + jobsubsidy + '\'' +
                ", lunchsubsidy='" + lunchsubsidy + '\'' +
                ", geographicalsubsidy='" + geographicalsubsidy + '\'' +
                ", fluctuatingwages='" + fluctuatingwages + '\'' +
                ", differentplacesubsidy='" + differentplacesubsidy + '\'' +
                ", Telephonesubsidy='" + Telephonesubsidy + '\'' +
                ", computersubsidy='" + computersubsidy + '\'' +
                ", financialsubsidy='" + financialsubsidy + '\'' +
                ", pilot='" + pilot + '\'' +
                ", turnpositive='" + turnpositive + '\'' +
                '}';
    }
}
