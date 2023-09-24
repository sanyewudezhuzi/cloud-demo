package com.zhuzi.config;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "com.zhuzi.client")
@Configuration
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level loggerLevel() {
        // 日志级别为BASIC，这是个枚举类型
        return Logger.Level.BASIC;
    }
}
