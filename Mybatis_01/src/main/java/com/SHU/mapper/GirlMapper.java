package com.SHU.mapper;

import com.SHU.pojo.girl;
import org.apache.ibatis.annotations.Param;

public interface GirlMapper {
    int insert(girl girl);

    girl queryById(Long id);

    girl queryByName(String name);

    /**
     * 加上一个注解@param即可
     * @param name
     * @param flower
     * @return
     */
    girl queryByNameFlower(@Param("name") String name, @Param("flower") String flower);

    girl queryByNameFlower2(girl g);

    girl queryByNameId(@Param("name")String name, @Param("id")Long id);
}
