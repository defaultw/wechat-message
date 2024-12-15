package com.dw.wechatmessage.v2.bus.config;

import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 公交信息查询配置
 *
 * @author Default.W
 * @date 2024/12/15
 */
@Component
@ConfigurationProperties(prefix = "bus.query")
public class BusQueryDataConfig {

    List<BusStopArriveQueryDTO> work;

    List<BusStopArriveQueryDTO> offWork;

    public List<BusStopArriveQueryDTO> getWork() {
        return work;
    }

    public void setWork(List<BusStopArriveQueryDTO> work) {
        this.work = work;
    }

    public List<BusStopArriveQueryDTO> getOffWork() {
        return offWork;
    }

    public void setOffWork(List<BusStopArriveQueryDTO> offWork) {
        this.offWork = offWork;
    }
}
