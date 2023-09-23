package com.zhuzi.order.service;

import com.zhuzi.order.mapper.OrderMapper;
import com.zhuzi.order.pojo.Order;
import com.zhuzi.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        // 2. 获取url
        // String url = "http://localhost:8081/user/" + order.getUserId();
        String url = "http://userservice/user/" + order.getUserId();

        // 3. 获取user数据并进行封装
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);

        // 4.返回
        return order;
    }
}
