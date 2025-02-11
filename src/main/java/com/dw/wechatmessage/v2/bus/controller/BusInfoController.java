package com.dw.wechatmessage.v2.bus.controller;

import com.alibaba.fastjson.JSON;
import com.dw.wechatmessage.v2.bus.config.BusQueryDataConfig;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveResultDTO;
import com.dw.wechatmessage.v2.bus.service.IBusInfoService;
import com.dw.wechatmessage.v2.bus.utils.Ip2LocalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 公交信息查询
 *
 * @author Default.W
 * @date 2024/12/15
 */
@Controller
public class BusInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BusInfoController.class);

    @Resource
    private IBusInfoService busInfoService;

    @Resource
    private BusQueryDataConfig busQueryDataConfig;

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model, @RequestParam("work") boolean work) {
        String realIp = request.getHeader("X-Forwarded-For");
        logger.info("当前访问X-Forwarded-For: {}, X-Forwarded-For: {}",
                request.getHeader("X-Forwarded-For"), realIp);
        List<BusStopArriveResultDTO> results = new ArrayList<>();
        List<BusStopArriveQueryDTO> busList = work ? busQueryDataConfig.getWork() : busQueryDataConfig.getOffWork();
        if (!CollectionUtils.isEmpty(busList)) {
            for (BusStopArriveQueryDTO workBus : busList) {
                BusStopArriveResultDTO data = busInfoService.queryBusStopArrive(workBus).getData();
                if (!Objects.isNull(data)) {
                    results.add(data);
                }
            }
        }
        model.addAttribute("realIp", realIp);
        try {
            String localByIpv4 = Ip2LocalUtil.getLocalByIpv4(realIp);
            model.addAttribute("realIp2Local", localByIpv4);
        } catch (Exception e) {
            logger.error("获取IP对应地址失败", e);
        }
        model.addAttribute("results", results);
        model.addAttribute("message", work ? "公交到站(上班)" : "公交到站(下班)");
        logger.info(JSON.toJSONString(results));
        return "index";
    }

}
