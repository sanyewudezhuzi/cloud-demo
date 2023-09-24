package com.zhuzi.user.web;

import com.zhuzi.user.config.PatternProperties;
import com.zhuzi.user.pojo.User;
import com.zhuzi.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
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

    @GetMapping("/header")
    public String header(@RequestHeader(name = "name", required = false) String name) {
        return name;
    }

}
