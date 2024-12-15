package com.dw.wechatmessage.v2.bus.dto;

/**
 * 查询公交到站信息请求参数
 *
 * @author Default.W
 * @date 2024/12/15
 */
public class BusStopArriveQueryDTO {

    private String lineId;

    private String lineName;

    private String stopId;

    private String stopName;

    private Integer metroType;

    private String language;

    private Integer direction;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Integer getMetroType() {
        return metroType;
    }

    public void setMetroType(Integer metroType) {
        this.metroType = metroType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "BusStopArriveQueryDTO{" +
                "lineId='" + lineId + '\'' +
                ", lineName='" + lineName + '\'' +
                ", stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", metroType='" + metroType + '\'' +
                ", language='" + language + '\'' +
                ", direction=" + direction +
                '}';
    }
}
