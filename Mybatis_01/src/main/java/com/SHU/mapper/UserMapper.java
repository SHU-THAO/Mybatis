package com.SHU.mapper;

import com.SHU.pojo.UserBlog;
import com.SHU.pojo.UserWithDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    UserWithDetail queryById(@Param("id") Integer id);


    UserBlog queryByIdWithBlog(@Param("id") Integer id);
}
