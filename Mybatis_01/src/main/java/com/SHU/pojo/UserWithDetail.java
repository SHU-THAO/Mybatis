package com.SHU.pojo;

public class UserWithDetail extends User{

    private UserDetail userDetail;

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + getuId() +
                ", phone='" + getPhone() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", createDate=" + getCreateDate() +
                ", status=" + getStatus() +"UserWithDetail{" +
                "userDetail=" + userDetail +
                '}';
    }
}
