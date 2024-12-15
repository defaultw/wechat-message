package com.dw.wechatmessage.service;

import com.dw.wechatmessage.dto.AppBusInfoDTO;
import com.dw.wechatmessage.dto.BusInfoDTO;

/**
 * 查询公交车相关信息服务
 *
 * @author Default.W
 * @date 2022/8/27
 */
public interface BusInfoService {

    /**
     * 获取公交车信息
     *
     * @return 到站信息
     */
    BusInfoDTO getBusInfo();

    /**
     * 获取公交车信息（app端）
     *
     * @return 到站信息
     */
    AppBusInfoDTO getAppBusInfos();

}
