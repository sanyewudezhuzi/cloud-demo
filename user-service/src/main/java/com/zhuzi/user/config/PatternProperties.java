package com.zhuzi.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "pattern") // 这个注解默认就是热更新
public class PatternProperties {
    private String dateformat;
}
