package com.zhuzi.order.mapper;

import com.zhuzi.order.pojo.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order findById(Long id);
}
