package com.dw.wechatmessage.v2.bus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 公交信息查询接口配置
 *
 * @author Default.W
 * @date 2024/12/15
 */
@Component
@ConfigurationProperties(prefix = "bus.interface")
public class BusInterfaceConfig {

    private String url;

    private String cityCode;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String toString() {
        return "BusInterfaceConfig{" +
                "url='" + url + '\'' +
                ", cityCode='" + cityCode + '\'' +
                '}';
    }
}
