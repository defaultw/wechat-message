package com.dw.wechatmessage.v1.dto;

/**
 * 公交到站信息回执
 *
 * @author Default.W
 * @date 2022/8/27
 */
public class BusInfoDTO {

    /**
     * 车牌
     */
    private String terminal;

    /**
     * 剩余站数
     */
    private String stopdis;

    /**
     * 距离
     */
    private String distance;

    /**
     * 剩余时间，单位秒
     */
    private String time;

    public BusInfoDTO() {
    }

    public BusInfoDTO(String info) {
        terminal = info;
        stopdis = info;
        distance = info;
        time = info;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getStopdis() {
        return stopdis;
    }

    public void setStopdis(String stopdis) {
        this.stopdis = stopdis;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BusInfoDTO{" +
                "terminal='" + terminal + '\'' +
                ", stopdis='" + stopdis + '\'' +
                ", distance='" + distance + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
