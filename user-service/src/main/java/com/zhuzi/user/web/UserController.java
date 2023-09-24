package com.zhuzi.user.web;

import com.zhuzi.user.config.PatternProperties;
import com.zhuzi.user.pojo.User;
import com.zhuzi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope // 使用@Value读取配置数据实现热更新
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }

    // 为了验证test开发环境，需要注释这段代码
    /* @Value("${pattern.dateformat}")
    private String dateformat;

    @GetMapping("/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat));
    } */

    @Autowired
    private PatternProperties patternProperties;

    @GetMapping("/now2")
    public String now2() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }

    @GetMapping("/info")
    public String info() {
        return patternProperties.getEnvShareValue();
    }

}
