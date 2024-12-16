package com.dw.wechatmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 启动类
 *
 * @author Default.W
 */
// @EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties
public class WechatMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatMessageApplication.class, args);
    }

}
