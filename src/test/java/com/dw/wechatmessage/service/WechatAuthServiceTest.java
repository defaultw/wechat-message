package com.dw.wechatmessage.service;

import com.alibaba.fastjson.JSONObject;
import com.dw.wechatmessage.v1.service.AuthService;
import com.dw.wechatmessage.v1.service.BusInfoService;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import com.dw.wechatmessage.v2.bus.dto.ResultDTO;
import com.dw.wechatmessage.v2.bus.service.IBusInfoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(WechatAuthServiceTest.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private BusInfoService busInfoService;

    @Autowired
    private IBusInfoService busInfoServiceV2;

    @Test
    public void getAccessToken() {
        authService.getAccessToken();
    }

    @Test
    public void getBusInfo() {
        busInfoService.getBusInfo();
    }

    @Test
    public void getBusInfoV2() {
        BusStopArriveQueryDTO dto = new BusStopArriveQueryDTO();
        dto.setDirection(0);
        dto.setLanguage("zh-cn");
        dto.setLineId("1256");
        dto.setLineName("莲亭专线");
        dto.setMetroType(0);
        dto.setStopId("3");
        dto.setStopName("新车公路民益路");

        ResultDTO resultDTO = busInfoServiceV2.queryBusStopArrive(dto);

        logger.info(JSONObject.toJSONString(resultDTO));
    }

}
