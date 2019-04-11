package com.SHU.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer uId;
    private String phone;
    private String password;
    private Date createDate;
    private Integer status;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }
}
