package com.dw.wechatmessage.v2.bus.dto;

import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 公交到站详细信息
 *
 * @author Default.W
 * @date 2024/12/15
 */
public class BusStopArriveResultDTO {

    private StopArriveInfo stopArriveInfo;

    private DispatchCarSchedule dispatchCarSchedule;

    /**
     * 当前发车信息
     */
    public static class StopArriveInfo {
        private String currentBusDistance;

        private String currentBusArriveTime;

        private String stopName;

        private String currentLicensePlate;

        public String getCurrentBusDistance() {
            if (StringUtils.isEmpty(currentBusDistance)) {
                return " 米";
            }
            // 原始数据单位为米，此处直接转换为公里
            BigDecimal distance = new BigDecimal(currentBusDistance);
            if (distance.compareTo(new BigDecimal(1000)) < 0) {
                return String.format("%s 米", currentBusDistance);
            } else {
                BigDecimal res = distance.divide(new BigDecimal("1000.000"), 3, RoundingMode.FLOOR);
                return String.format("%s 公里", res.toPlainString());
            }
        }

        public void setCurrentBusDistance(String currentBusDistance) {
            this.currentBusDistance = currentBusDistance;
        }

        public String getCurrentBusArriveTime() {
            return currentBusArriveTime;
        }

        public void setCurrentBusArriveTime(String currentBusArriveTime) {
            this.currentBusArriveTime = currentBusArriveTime;
        }

        public String getStopName() {
            return stopName;
        }

        public void setStopName(String stopName) {
            this.stopName = stopName;
        }

        public String getCurrentLicensePlate() {
            return currentLicensePlate;
        }

        public void setCurrentLicensePlate(String currentLicensePlate) {
            this.currentLicensePlate = currentLicensePlate;
        }

        @Override
        public String toString() {
            return "StopArriveInfo{" +
                    "currentBusDistance='" + currentBusDistance + '\'' +
                    ", currentBusArriveTime='" + currentBusArriveTime + '\'' +
                    ", stopName='" + stopName + '\'' +
                    ", currentLicensePlate='" + currentLicensePlate + '\'' +
                    '}';
        }
    }

    /**
     * 等待发车信息
     */
    public static class DispatchCarSchedule {
        private String scheduleMsg;

        private String lineName;

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getScheduleMsg() {
            return scheduleMsg;
        }

        public void setScheduleMsg(String scheduleMsg) {
            this.scheduleMsg = scheduleMsg;
        }

        @Override
        public String toString() {
            return "DispatchCarSchedule{" +
                    "scheduleMsg='" + scheduleMsg + '\'' +
                    ", lineName='" + lineName + '\'' +
                    '}';
        }
    }

    public StopArriveInfo getStopArriveInfo() {
        return stopArriveInfo;
    }

    public void setStopArriveInfo(StopArriveInfo stopArriveInfo) {
        this.stopArriveInfo = stopArriveInfo;
    }

    public DispatchCarSchedule getDispatchCarSchedule() {
        return dispatchCarSchedule;
    }

    public void setDispatchCarSchedule(DispatchCarSchedule dispatchCarSchedule) {
        this.dispatchCarSchedule = dispatchCarSchedule;
    }

    @Override
    public String toString() {
        return "BusStopArriveResultDTO{" +
                "stopArriveInfo=" + stopArriveInfo +
                ", dispatchCarSchedule=" + dispatchCarSchedule +
                '}';
    }
}
