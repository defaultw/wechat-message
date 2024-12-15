package com.dw.wechatmessage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dw.wechatmessage.config.MessageConfig;
import com.dw.wechatmessage.dto.WechatJsonMessageDTO;
import com.dw.wechatmessage.service.AuthService;
import com.dw.wechatmessage.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消息发送实现类
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Service
public class MessageServiceImpl implements MessageService {

    Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Resource
    private MessageConfig messageConfig;

    @Resource
    private AuthService authService;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public void sendTemplateMessage(WechatJsonMessageDTO requestData) {
        // 请求url拼接token
        String url = String.format(messageConfig.getSendMessageUrl(), authService.getAccessToken().getAccessToken());
        ResponseEntity<JSONObject> res = restTemplate.postForEntity(url, requestData, JSONObject.class);
        logger.debug("Message request result: {}", res.getStatusCode());
    }


}
