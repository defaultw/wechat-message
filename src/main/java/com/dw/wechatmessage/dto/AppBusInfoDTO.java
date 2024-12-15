package com.dw.wechatmessage.dto;

import java.util.List;

/**
 * 交通委员会app接口回执
 *
 * @author Default.W
 * @date 2022/8/31
 */
public class AppBusInfoDTO {

    /**
     * 满足app端接口回执而构建数组
     */
    private List<BusInfoDTO> cars;

    public List<BusInfoDTO> getCars() {
        return cars;
    }

    public void setCars(List<BusInfoDTO> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "AppBusInfoDTO{" +
                "cars=" + cars +
                '}';
    }
}
