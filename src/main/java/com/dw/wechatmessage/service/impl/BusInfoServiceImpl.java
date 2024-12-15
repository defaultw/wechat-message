package com.dw.wechatmessage.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dw.wechatmessage.config.AppBusInfoConfig;
import com.dw.wechatmessage.config.BusInfoConfig;
import com.dw.wechatmessage.dto.AppBusInfoDTO;
import com.dw.wechatmessage.dto.BusInfoDTO;
import com.dw.wechatmessage.service.BusInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author Default.W
 * @date 2022/8/27
 */
@Service
public class BusInfoServiceImpl implements BusInfoService {

    Logger logger = LoggerFactory.getLogger(BusInfoServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private BusInfoConfig busInfoConfig;

    @Resource
    private AppBusInfoConfig appBusInfoConfig;

    @Override
    public BusInfoDTO getBusInfo() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("sid", busInfoConfig.getBusId());
        map.add("stopid", busInfoConfig.getStopId());
        map.add("stoptype", busInfoConfig.getStopType());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Accept", "*/*");
        HttpEntity httpEntity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
                busInfoConfig.getRequestUrl(), httpEntity, String.class);

        List<BusInfoDTO> info = JSONArray.parseArray(response.getBody(), BusInfoDTO.class);

        logger.debug("result is {}", info.get(0).toString());
        return info.get(0);
    }

    @Override
    public AppBusInfoDTO getAppBusInfos() {
        ResponseEntity<JSONObject> result = restTemplate.getForEntity(appBusInfoConfig.getRequestUrl(), JSONObject.class);
        return JSON.toJavaObject(result.getBody(), AppBusInfoDTO.class);
    }
}
