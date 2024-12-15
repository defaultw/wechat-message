package com.dw.wechatmessage.service;

import com.dw.wechatmessage.v1.service.AuthService;
import com.dw.wechatmessage.v1.service.BusInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 用户相关信息获取测试
 *
 * @author Default.W
 * @date 2022/8/27
 */
@SpringBootTest
public class WechatAuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private BusInfoService busInfoService;

    @Test
    public void getAccessToken() {
        authService.getAccessToken();
    }

    @Test
    public void getBusInfo() {
        busInfoService.getBusInfo();
    }

}
