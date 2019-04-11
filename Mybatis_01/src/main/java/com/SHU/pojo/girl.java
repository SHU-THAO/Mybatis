package com.SHU.pojo;

import java.util.Date;

public class girl {

    private Long id;
    private String name;
    private String flower;
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public girl(Long id, String name, String flower, Date birthday) {
        this.id = id;
        this.name = name;
        this.flower = flower;
        this.birthday = birthday;
    }

    public girl() {
    }
}
