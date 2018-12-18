package com.example.springbootTest.rabbtimqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 测试
 * @Author lss0555
 * @Date 2018/12/17/017 16:05
 **/
@RestController
public class RabbitSendMsgController {
    @Autowired
    RabbitMsgProduct msgProducer;

    //单发送单接收
    @GetMapping("/sendMsg1")
    public String sendMsg1(String msg){
        msgProducer.sendMsg1(msg);
        return "ok";
    }

    // 单发送多接收
    @GetMapping("/sendMsg2")
    public String sendMsg2(String msg){
        msgProducer.sendMsg2(msg);
        return "ok";
    }

}
