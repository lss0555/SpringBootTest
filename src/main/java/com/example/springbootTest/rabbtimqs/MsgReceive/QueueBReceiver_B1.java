package com.example.springbootTest.rabbtimqs.MsgReceive;

import com.example.springbootTest.rabbtimqs.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消费者
 * @Author lss0555
 * @Date 2018/12/17/017 17:13
 **/
@Component
public class QueueBReceiver_B1 {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    public void process(String content) {
        logger.info("接收处理队列B1消息： " + content);
    }
}