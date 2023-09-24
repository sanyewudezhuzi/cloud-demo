package com.zhuzi.order.service;

import com.zhuzi.order.client.UserClient;
import com.zhuzi.order.mapper.OrderMapper;
import com.zhuzi.order.pojo.Order;
import com.zhuzi.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        User user = userClient.findById(order.getUserId());
        order.setUser(user);

        // 4.返回
        return order;
    }
}
