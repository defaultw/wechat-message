package com.dw.wechatmessage.v2.bus.service.impl;

import com.alibaba.fastjson2.JSON;
import com.dw.wechatmessage.v2.bus.config.BusInterfaceConfig;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import com.dw.wechatmessage.v2.bus.dto.ResultDTO;
import com.dw.wechatmessage.v2.bus.service.IBusInfoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 查询公交信息
 *
 * @author Default.W
 * @date 2024/12/15
 */
@Service
public class BusInfoService implements IBusInfoService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private BusInterfaceConfig busInterfaceConfig;

    /**
     * 查询公交到站详情
     *
     * @param query 查询参数
     * @return 公交到站详情
     */
    @Override
    public ResultDTO queryBusStopArrive(BusStopArriveQueryDTO query) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "*/*");
        headers.set("x-saic-citycode", busInterfaceConfig.getCityCode());
        HttpEntity<BusStopArriveQueryDTO> httpEntity = new HttpEntity<>(query, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                busInterfaceConfig.getUrl(), httpEntity, String.class);

        return JSON.parseObject(response.getBody(), ResultDTO.class);
    }
}
