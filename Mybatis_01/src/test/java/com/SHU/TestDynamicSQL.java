package com.SHU;

import com.SHU.mapper.AddressesMapper;
import com.SHU.pojo.Addresses;
import com.SHU.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestDynamicSQL {

    @Test
    public void m1(){
        //按照ID查询
    }

    @Test
    public void m2(){
        SqlSession sqlSession = MybatisUtil.getSession();

        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);


        List<Addresses> addresses = mapper.queryByCountryCity("中国",null);

        System.out.println(addresses);
        sqlSession.close();
    }

    //按照ID更新
    @Test
    public void m3(){
        SqlSession sqlSession = MybatisUtil.getSession();

        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);

        Addresses addresses = new Addresses();
        addresses.setAddrId(5);
        addresses.setCity("china");
        addresses.setCountry("中国");
        addresses.setState("ShangHai");
        addresses.setStreet("SHU");
        addresses.setZip("200444");

        mapper.update(addresses);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m4(){
        SqlSession sqlSession = MybatisUtil.getSession();

        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);

        Addresses addresses = new Addresses();
        addresses.setCity("china");
        addresses.setCountry("中国");
        addresses.setState("ShangHai");

        List<Addresses> addresses2 = mapper.query(addresses);

        System.out.println(addresses2.get(0).getAddrId());

        sqlSession.close();
    }

    @Test
    public void m5(){
        SqlSession sqlSession = MybatisUtil.getSession();

        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);

        Addresses addresses = new Addresses();
        addresses.setCity("china");
        addresses.setCountry("中国");
        addresses.setState("ShangHai");

        List<Addresses> addresses2 = mapper.queryTrim(addresses);

        System.out.println(addresses2);
        sqlSession.close();
    }

    @Test
    public void m6(){
        SqlSession sqlSession = MybatisUtil.getSession();

        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Addresses> addresses2 = mapper.queryIds(list);

        System.out.println(addresses2);
        sqlSession.close();
    }
    @Test
    public void m7(){

        SqlSession sqlSession = MybatisUtil.getSession();
        //模糊查询解决方案一：在应用程序层面加入%%拼接
        //AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);
        //List<Addresses> addresses = mapper.queryLike("%ch%");
        //System.out.println(addresses);

        //模糊查询解决方案二：通过mysql的函数完成concat
        //AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);
        //List<Addresses> addresses = mapper.queryLike("ch");
        //System.out.println(addresses);

        //模糊查询解决方案三：通过bind对city重新进行绑定设置，之后引用新绑定的变量
        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);
        List<Addresses> addresses = mapper.queryLike("ch");
        System.out.println(addresses);
        sqlSession.close();
    }

    /*
        如果开启了二级缓存
        先去耳机缓存中尝试命中
        如果也无法命中
        尝试去以及缓存当中命中
        若还不命中，再去数据库中查询
     */
    /*
            1. 一级缓存是同一个会话级别的，只有在同一个会话中才有效
            这里关闭sqlSession，上一个会话的一级缓存便不再有效
            2. 如果查询之后进行了增删改的行为，将导致缓存失效。
            3. 强制清空缓存 sqlSession.clearCache();
    */
    @Test
    public void m8(){
        SqlSession sqlSession = MybatisUtil.getSession();
        AddressesMapper mapper = sqlSession.getMapper(AddressesMapper.class);
        List<Addresses> addresses = mapper.listAll();
        //System.out.println(addresses);
        sqlSession.clearCache();
        List<Addresses> addresses2 = mapper.listAll();
        //System.out.println(addresses2);
        sqlSession.close();
    }
    //二级缓存实验
    @Test
    public void m9(){
        SqlSession sqlSession1 = MybatisUtil.getSession();
        SqlSession sqlSession2 = MybatisUtil.getSession();
        AddressesMapper mapper1 = sqlSession1.getMapper(AddressesMapper.class);
        AddressesMapper mapper2 = sqlSession2.getMapper(AddressesMapper.class);
        mapper1.listAll();
        sqlSession1.close();
        mapper2.listAll();
        sqlSession1.close();
    }
}
