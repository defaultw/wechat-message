package com.dw.wechatmessage.v1.service;

import com.dw.wechatmessage.v1.dto.AccessTokenDTO;

/**
 * 授权相关接口
 *
 * @author Default.W
 * @date 2022/8/27
 */
public interface AuthService {

    /**
     * 获取token
     *
     * @return 返回access_token
     */
    AccessTokenDTO getAccessToken();

}
