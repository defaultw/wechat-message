package com.dw.wechatmessage.v1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信相关配置类
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    /**
     * 测试号appid
     */
    private String appId;

    /**
     * 测试号密码
     */
    private String secret;

    /**
     * 获取token的请求地址
     */
    private String accessTokenUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }
}
