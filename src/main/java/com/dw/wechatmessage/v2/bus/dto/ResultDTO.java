package com.dw.wechatmessage.v2.bus.dto;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * TODO
 *
 * @author Default.W
 * @date 2024/12/15
 */
public class ResultDTO {

    private String errMsg;

    private Integer errCode;

    @JSONField(name = "TID")
    private String uuid;

    private Long now;

    private String nowTime;

    private BusStopArriveResultDTO data;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public String getNowTime() {
        return nowTime;
    }

    public void setNowTime(String nowTime) {
        this.nowTime = nowTime;
    }

    public BusStopArriveResultDTO getData() {
        return data;
    }

    public void setData(BusStopArriveResultDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "errMsg='" + errMsg + '\'' +
                ", errCode=" + errCode +
                ", uuid='" + uuid + '\'' +
                ", now=" + now +
                ", nowTime='" + nowTime + '\'' +
                ", data=" + data +
                '}';
    }
}
