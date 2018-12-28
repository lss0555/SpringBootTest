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
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg1(msg);
        return "success";
    }

    // 单发送多接收
    @GetMapping("/sendMsg2")
    public String sendMsg2(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg2(msg);
        return "success";
    }

    // 发布订阅模式  FanoutExchange
    @GetMapping("/sendMsg3")
    public String sendMsg3(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg3(msg);
        return "success";
    }

    // 发布订阅模式  DirectExchange
    @GetMapping("/sendMsg4")
    public String sendMsg4(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg4(msg);
        return "success";
    }


    // 路由模式
    @GetMapping("/sendMsg5")
    public String sendMsg5(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg5(msg);
        return "success";
    }

    // 主题模式
    @GetMapping("/sendMsg6")
    public String sendMsg6(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg6_1(msg);
        return "success";
    }

    // 主题模式
    @GetMapping("/sendMsg7")
    public String sendMsg7(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg6_2(msg);
        return "success";
    }

    // 主题模式
    @GetMapping("/sendMsg8")
    public String sendMsg8(String msg){
        if(msg==null&&msg.equals("")){
            return "error:发送消息不能为空";
        }
        msgProducer.sendMsg6_3(msg);
        return "success";
    }

}
