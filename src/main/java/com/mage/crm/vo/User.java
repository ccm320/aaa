package com.mage.crm.vo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int id;//用户id
    private String userName;//用户名
    private String userPwd;//用户密码
    private String trueName;//真是姓名
    private String email;//邮箱
    private String phone;//手机号
    private Integer isValid;//是否有效 1有效，0无效
    private Date createDate;//创建时间
    private Date updateDate;//更新时间

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public String getTrueName() {
        return trueName;
    }
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getIsValid() {
        return isValid;
    }
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User(Integer id, String userName, String userPwd, String trueName, String email, String phone, Integer isValid, Date createDate, Date updateDate) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.trueName = trueName;
        this.email = email;
        this.phone = phone;
        this.isValid = isValid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", trueName='" + trueName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isValid=" + isValid +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}