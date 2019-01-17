package com.example.redis.config;

import com.example.redis.receive.MsgReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 消息订阅配置
 * @Author lss0555
 * @Date 2019/1/17/017 11:38
 **/

@Configuration
public class SubscriberConfig {
    /**
     * 创建连接工厂
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter,new PatternTopic("paragram_vt"));
        return container;
    }

    /**
     * 绑定消息监听者和接收监听的方法
     * @param receiver
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(MsgReceiver receiver){
        return new MessageListenerAdapter(receiver,"receiveMessage");
    }

    /**
     * 注册订阅者
     * @param latch
     * @return
     */
    @Bean
    public MsgReceiver receiver(CountDownLatch latch){
        return new MsgReceiver(latch);
    }

    /**
     * 计数器，用来控制线程
     * @return
     */
    @Bean
    public CountDownLatch latch(){
        return new CountDownLatch(1);//指定了计数的次数 1
    }

}
