package com.SHU.mapper;

import com.SHU.pojo.Addresses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressesMapper{
    Addresses queryById(Integer addrId);

    List<Addresses> queryByCountryCity(@Param("country")String country,@Param("city") String city);

    int update(Addresses addresses);

    List<Addresses> query(Addresses addresses);

    List<Addresses> queryTrim(Addresses addresses);

    List<Addresses> queryIds(List<Integer> list);

    List<Addresses> queryLike(@Param("city") String city);

    List<Addresses> listAll();
}
