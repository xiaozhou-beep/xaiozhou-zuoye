package com.fh.model;

import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/13
 * @Version V1.0
 **/
public class UserInfo {
    //Shop_user(会员表)：可以先不做注册功能，直接在会员表中写死一批数据
    private Integer Id;// 会员id
    private String userName;// 用户名
    private String passWord;// 密码
    private Integer phoneNumber;// 手机号
    private Integer sex;// 性别 1代表男 2代表女
    private String email;// 邮箱
    private Date  registerTime;// 注册时间
    private String uuid;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
