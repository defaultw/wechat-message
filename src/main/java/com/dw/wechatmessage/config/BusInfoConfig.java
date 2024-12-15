package com.dw.wechatmessage.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 公交到站提醒模板信息配置
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Component
@ConfigurationProperties(prefix = "bus.message.template")
public class BusInfoConfig {

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
     * 公交id
     */
    private String busId;

    /**
     * 公交站id
     */
    private String stopId;

    /**
     * 上行或者下行
     */
    private String stopType;

    /**
     * 请求的url
     */
    private String requestUrl;

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopType() {
        return stopType;
    }

    public void setStopType(String stopType) {
        this.stopType = stopType;
    }

    @Override
    public String toString() {
        return "BusInfoTempLate{" +
                "busId='" + busId + '\'' +
                ", stopId='" + stopId + '\'' +
                ", stopType='" + stopType + '\'' +
                '}';
    }
}
