package com.zhuzi.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level loggerLevel() {
        // 日志级别为BASIC，这是个枚举类型
        return Logger.Level.BASIC;
    }
}
