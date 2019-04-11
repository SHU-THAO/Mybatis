package com.SHU.pojo;

import java.util.List;

public class UserBlog extends User{
    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }


}
