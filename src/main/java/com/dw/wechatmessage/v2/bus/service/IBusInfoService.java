package com.dw.wechatmessage.v2.bus.service;

import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import com.dw.wechatmessage.v2.bus.dto.ResultDTO;

/**
 * 查询公交信息
 *
 * @author Default.W
 * @date 2024/12/15
 */
public interface IBusInfoService {

    /**
     * 查询公交到站详情
     *
     * @param query 查询参数
     * @return 公交到站详情
     */
    public ResultDTO queryBusStopArrive(BusStopArriveQueryDTO query);
}
