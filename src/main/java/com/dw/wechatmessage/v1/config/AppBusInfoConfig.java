package com.dw.wechatmessage.v1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * App端接口相关配置
 *
 * @author Default.W
 * @date 2022/8/31
 */
@Component
@ConfigurationProperties(prefix = "app.message.template")
public class AppBusInfoConfig {

    /**
     * 消息模板id
     */
    private String templateId;

    /**
     * 消息接受用户
     */
    private String toUser;

    /**
     * 定时发送频率
     */
    private String cron;

    /**
     * 请求地址
     */
    private String requestUrl;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String toString() {
        return "AppBusInfoConfig{" +
                "templateId='" + templateId + '\'' +
                ", toUser='" + toUser + '\'' +
                ", cron='" + cron + '\'' +
                ", requestUrl='" + requestUrl + '\'' +
                '}';
    }
}
