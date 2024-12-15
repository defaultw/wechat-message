package com.dw.wechatmessage.v2.bus.dto;

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
            return currentBusDistance;
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
