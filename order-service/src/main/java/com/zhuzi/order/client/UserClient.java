package com.zhuzi.order.client;

import com.zhuzi.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 定义远程调用
@FeignClient("userservice")
public interface UserClient {

    // 根据用户id获取用户对象数据
    @GetMapping("/user/{id}") // 必须写全路径，否则兼容性不好
    User findById(@PathVariable("id") Long id); // 所有参数必须起别名，否则兼容性不好

}