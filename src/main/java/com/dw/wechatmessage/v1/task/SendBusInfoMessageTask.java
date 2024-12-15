package com.dw.wechatmessage.v1.task;

import com.dw.wechatmessage.v1.config.BusInfoConfig;
import com.dw.wechatmessage.v1.dto.AppBusInfoDTO;
import com.dw.wechatmessage.v1.dto.BusInfoDTO;
import com.dw.wechatmessage.v1.dto.WechatJsonMessageDTO;
import com.dw.wechatmessage.v1.service.BusInfoService;
import com.dw.wechatmessage.v1.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 定时发送公交信息
 *
 * @author Default.W
 * @date 2022/8/28
 */
// @Component
public class SendBusInfoMessageTask {

    private final Logger logger = LoggerFactory.getLogger(SendBusInfoMessageTask.class);

    @Resource
    private BusInfoService busInfoService;

    @Resource
    private MessageService messageService;

    @Resource
    private BusInfoConfig busInfoConfig;

    private static final String V_COLOR = "#173177";

    @Scheduled(cron = "${app.message.template.cron}")
    public void send() {
        logger.info("SendBusInfoMessageTask is start...");
        // 基本消息体
        BusInfoDTO data = new BusInfoDTO("等待发车");
        // 请求公交信息
        AppBusInfoDTO appDate = busInfoService.getAppBusInfos();
        if (appDate == null || appDate.getCars() == null || appDate.getCars().isEmpty()) {
            logger.debug("Waiting for departure....");
        } else {
            data = busInfoService.getAppBusInfos().getCars().get(0);
        }
        // 消息发送
        messageService.sendTemplateMessage(constructorMessage(data));
        logger.info("SendBusInfoMessageTask is end.");
    }

    /**
     * 构造公交到站信息模板
     *
     * @param data 公交到站信息
     * @return 请求消息体
     */
    private WechatJsonMessageDTO constructorMessage(BusInfoDTO data) {
        WechatJsonMessageDTO requestData = new WechatJsonMessageDTO();
        requestData.setTouser(busInfoConfig.getToUser());
        requestData.setTemplate_id(busInfoConfig.getTemplateId());
        requestData.setTopcolor("#FF0000");
        requestData.putDate("licensePlate", data.getTerminal(), V_COLOR)
                .putDate("timeRemaining", data.getTime(), V_COLOR)
                .putDate("stopRemaining", data.getStopdis(), V_COLOR)
                .putDate("distanceRemaining", data.getDistance(), V_COLOR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 获取 当前系统默认时区 的 本地时间
        LocalDateTime nowDateTime = LocalDateTime.now();
        // 格式化时间
        String dateTimeString = formatter.format(nowDateTime);
        requestData.putDate("currentTime", dateTimeString, "#FF0000");
        return requestData;
    }


}
