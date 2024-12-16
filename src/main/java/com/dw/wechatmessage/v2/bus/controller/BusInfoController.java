package com.dw.wechatmessage.v2.bus.controller;

import com.alibaba.fastjson.JSON;
import com.dw.wechatmessage.v2.bus.config.BusQueryDataConfig;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveQueryDTO;
import com.dw.wechatmessage.v2.bus.dto.BusStopArriveResultDTO;
import com.dw.wechatmessage.v2.bus.service.IBusInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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
    public String index(Model model, @RequestParam("work") boolean work) {
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
        model.addAttribute("results", results);
        model.addAttribute("message", work ? "公交到站(上班)" : "公交到站(下班)");
        logger.info(JSON.toJSONString(results));
        return "index";
    }

}
