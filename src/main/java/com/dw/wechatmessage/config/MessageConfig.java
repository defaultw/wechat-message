package com.dw.wechatmessage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 消息相关配置
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Component
@ConfigurationProperties(prefix = "message")
public class MessageConfig {

    /**
     * 发送消息请求的接口地址
     */
    private String sendMessageUrl;

    public String getSendMessageUrl() {
        return sendMessageUrl;
    }

    public void setSendMessageUrl(String sendMessageUrl) {
        this.sendMessageUrl = sendMessageUrl;
    }
}
