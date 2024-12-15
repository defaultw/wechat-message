package com.dw.wechatmessage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dw.wechatmessage.config.WechatConfig;
import com.dw.wechatmessage.dto.AccessTokenDTO;
import com.dw.wechatmessage.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 授权相关接口实现类
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Service
public class WechatAuthServiceImpl implements AuthService {

    Logger logger = LoggerFactory.getLogger(WechatAuthServiceImpl.class);

    @Resource
    private WechatConfig wechatConfig;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public AccessTokenDTO getAccessToken() {
        String url = String.format(wechatConfig.getAccessTokenUrl(), wechatConfig.getAppId(),
                wechatConfig.getSecret());
        ResponseEntity<JSONObject> result = restTemplate.getForEntity(url, JSONObject.class);
        logger.debug("Get token method status: {}", result.getStatusCode());
        return JSON.toJavaObject(result.getBody(), AccessTokenDTO.class);
    }
}
