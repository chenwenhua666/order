package com.plm.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author : cwh
 * 2018/12/25 0025
 * description ：
 */
@Data
@Component
@ConfigurationProperties(prefix = "author")
@RefreshScope
public class AuthorConfig {
    private String name;
    private Integer age;
}
