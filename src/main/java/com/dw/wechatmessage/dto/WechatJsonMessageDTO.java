package com.dw.wechatmessage.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信通用的消息发送接口请求体
 *
 * @author Default.W
 * @date 2022/8/27
 */
public class WechatJsonMessageDTO {

    /**
     * 接收消息的用户
     */
    private String touser;

    /**
     * 模板id
     */
    private String template_id;

    /**
     *
     */
    private String topcolor;

    /**
     * 发送的数据
     */
    private Map<String, Map<String, String>> data;

    public WechatJsonMessageDTO() {
        data = new HashMap<>();
    }

    public WechatJsonMessageDTO putDate(String key, String value, String color) {
        Map<String, String> m = new HashMap<>(2);
        m.put("value", value);
        m.put("color", color);
        data.put(key, m);
        return this;
    }


    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SendMessageBO{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", topcolor='" + topcolor + '\'' +
                ", data=" + data +
                '}';
    }
}
