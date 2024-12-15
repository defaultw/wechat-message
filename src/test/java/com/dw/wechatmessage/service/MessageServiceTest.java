package com.dw.wechatmessage.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 消息服务测试类
 *
 * @author Default.W
 * @date 2022/8/27
 */
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void sendMessage() {
        messageService.sendTemplateMessage(null);
    }


}
