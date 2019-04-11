package com.SHU;

import com.SHU.mapper.UserMapper;
import com.SHU.pojo.UserBlog;
import com.SHU.pojo.UserWithDetail;
import com.SHU.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestResult {
    @Test
    public void m1(){
        SqlSession sqlSession = MybatisUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserWithDetail userWithDetail = mapper.queryById(1);

        System.out.println(userWithDetail);

        sqlSession.close();
    }

    @Test
    public void m2(){
        SqlSession sqlSession = MybatisUtil.getSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserBlog userBlog = mapper.queryByIdWithBlog(1);

        System.out.println(userBlog.getBlogs());

        sqlSession.close();
    }
}
