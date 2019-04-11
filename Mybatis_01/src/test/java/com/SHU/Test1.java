package com.SHU;

import com.SHU.mapper.GirlMapper;
import com.SHU.pojo.girl;
import com.SHU.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class Test1 {

    @Test
    public void m1(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
        girl g = new girl();
        g.setName("girl2");
        g.setFlower("flower2");
        g.setBirthday(new Date());

        mapper.insert(g);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void m2(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
        girl g = mapper.queryById(1l);

        System.out.println(g.getName());

        sqlSession.close();
    }

    @Test
    public void m3(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
        girl g = mapper.queryByName("girl");

        System.out.println(g);

        sqlSession.close();
    }

    @Test
    public void m4(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
        girl g = mapper.queryByNameFlower("girl","flower");

        System.out.println(g.getId());

        sqlSession.close();
    }

    @Test
    public void m5(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);
        girl g = new girl();
        g.setName("lady");
        g.setFlower("玫瑰");
        girl g2 = mapper.queryByNameFlower2(g);

        System.out.println(g2.getId());

        sqlSession.close();
    }

    @Test
    public void m6(){
        SqlSession sqlSession = MybatisUtil.getSession();

        GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);

        girl g = mapper.queryByNameId("Lady",1L);

        System.out.println(g.getBirthday());
        sqlSession.close();
    }
}
