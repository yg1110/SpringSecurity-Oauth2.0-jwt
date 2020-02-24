package com.security_blog.yg1110.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.security_blog.yg1110.dto.Home;

@Mapper
public interface HomeMapper {
       @Select("SELECT * FROM home WHERE name = #{name}")
       public Home readHome(@Param("name") String name);
}