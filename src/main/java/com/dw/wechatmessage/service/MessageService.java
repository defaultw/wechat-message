package com.dw.wechatmessage.service;

import com.dw.wechatmessage.dto.WechatJsonMessageDTO;

/**
 * 消息相关操作服务
 *
 * @author Default.W
 * @date 2022/8/27
 */
public interface MessageService {

    /**
     * 发送模板消息
     *
     * @param data 微信通用的消息发送接口请求体
     */
    void sendTemplateMessage(WechatJsonMessageDTO data);

}
