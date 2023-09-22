package com.zhuzi.user.mapper;

import com.zhuzi.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    
    @Select("select * from tb_user where id = #{id}")
    User findById(@Param("id") Long id);
}