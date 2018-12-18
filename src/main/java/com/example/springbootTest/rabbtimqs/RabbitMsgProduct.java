package com.example.springbootTest.rabbtimqs;

import com.alibaba.druid.sql.visitor.functions.Lpad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Description 消息生产者
 * @Author lss0555
 * @Date 2018/12/17/017 17:10
 **/
@Component
public class RabbitMsgProduct {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入
     */
    @Autowired
    public RabbitMsgProduct(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        //监听回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (ack) {
                    logger.info("消息消费success");
                } else {
                    logger.info("消息消费faile:" + cause);
                }
            }
        }); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    /**
     * @Description   helloword模式   单发送单接收
     **/
    public void sendMsg1(String content) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_A,content);
    }

    /**
     * @Description    单发送多接收
     **/
    public void sendMsg2(String content) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_B,content);
    }

    //发送消息
    public void sendMsg22(String content) {
        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
        //把消息放入ROUTINGKEY_A对应的队列当中去，对应的是队列A
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A, RabbitConfig.ROUTINGKEY_A, content, correlationId);
    }
}