package com.example.redis.receive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 消息接收
 * @Author lss0555
 * @Date 2019/1/17/017 11:32
 **/
public class MsgReceiver {
    private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

    private CountDownLatch latch;

    @Autowired
    public MsgReceiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        logger.info("消息接收:" + message);
        latch.countDown();
    }
}
