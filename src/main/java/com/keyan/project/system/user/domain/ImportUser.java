package com.keyan.project.system.user.domain;

import com.keyan.framework.aspectj.lang.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

public class ImportUser implements Serializable {
    @Excel(name = "登录名称", column = "A")
    private String loginName;

    @Excel(name = "用户名称", column = "B")
    private String userName;

    @Excel(name = "部门名称", column = "C")
    private String deptName;

    @Excel(name = "用户性别", column = "D")
    private String sex;
    @Excel(name = "生日", column = "E")
    private Date birthday;

    @Excel(name = "手机号码", column = "F")
    private String phonenumber;

    @Excel(name = "用户邮箱", column = "G")
    private String email;

    @Excel(name = "邮编", column = "H")
    private String postalcode;
    @Excel(name = "办公地址", column = "I")
    private String officeaddress;

    @Excel(name = "员工职位", column = "J")
    private String slot;

    @Excel(name = "员工职级", column = "K")
    private String rank;

    @Excel(name = "基本工资", column = "L")
    private String basicpay;
    @Excel(name = "技能补贴", column = "M")
    private String skillssubsidy;
    @Excel(name = "职务补贴", column = "N")
    private String jobsubsidy;
    @Excel(name = "午餐补贴", column = "O")
    private String lunchsubsidy;
    @Excel(name = "地域补贴", column = "P")
    private String geographicalsubsidy;
    @Excel(name = "浮动工资", column = "Q")
    private String fluctuatingwages;
    @Excel(name = "异地补贴", column = "R")
    private String differentplacesubsidy;
    @Excel(name = "通话补贴", column = "S")
    private String Telephonesubsidy;
    @Excel(name = "自备电脑补贴", column = "T")
    private String computersubsidy;
    @Excel(name = "财务证书补贴", column = "U")
    private String financialsubsidy;
    @Excel(name = "是否试用", column = "V")
    private String pilot;
    @Excel(name = "是否转正", column = "W")
    private String turnpositive;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSex() {
        return sex.equals("男") ? "0" : "1";
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
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
        return pilot.equals("是") ? "Y" : "N";
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public String getTurnpositive() {
        return turnpositive.equals("是") ? "Y" : "N";
    }

    public void setTurnpositive(String turnpositive) {
        this.turnpositive = turnpositive;
    }

    @Override
    public String toString() {
        return "ImportUser{" +
                "loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", officeaddress='" + officeaddress + '\'' +
                ", slot='" + slot + '\'' +
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
