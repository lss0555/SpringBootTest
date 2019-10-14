package com.example.rabbitmq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description rabbitmq配置类
 * @Author lss0555
 * @Date 2018/12/17/017 16:33
 **/
@Configuration
public class RabbitConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public static final String EXCHANGE_A = "ecchange_fanout";
    public static final String EXCHANGE_B = "exchange_direct";
    public static final String EXCHANGE_C = "exchange_header";
    public static final String EXCHANGE_D = "exchange_topic";


    public static final String QUEUE_A = "QUEUE_A";
    public static final String QUEUE_B = "QUEUE_B";
    public static final String QUEUE_C = "QUEUE_C";
    public static final String QUEUE_D = "QUEUE_D";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";

    @Bean
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }




    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_A);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_B);
    }

    @Bean
    public HeadersExchange headersexchange() {
        return new HeadersExchange(EXCHANGE_C);
    }

    @Bean
    public TopicExchange topicexchange() {
        return new TopicExchange(EXCHANGE_D);
    }

    /**
     * 实例化队列
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, true); //队列持久
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_B, false); //队列持久
    }

    @Bean
    public Queue queueC() {
        return new Queue(QUEUE_C, false); //队列持久
    }
    @Bean
    public Queue queueD() {
        return new Queue(QUEUE_D, false); //队列持久
    }


    //针对DirectExchange交换机:把队列绑定到交换机上面
    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(directExchange()).with(RabbitConfig.ROUTINGKEY_A);
    }

    
    /**
     * @Description:针对FanoutExchange交换机  将A.B.C队列绑定到交换机A上面
     **/
    @Bean
    Binding bindingExchangeB(Queue queueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeC(Queue queueC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeD(Queue queueD, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueD).to(fanoutExchange);
    }


    //针对主题模式交换机,绑定到消息队列C  前缀匹配到topic.lss0555 即可接受
    @Bean
    Binding bindingExchangeMessage(Queue queueC, TopicExchange exchange) {
        return BindingBuilder.bind(queueC).to(exchange).with("topic.lss0555");
    }
    //针对主题模式交换机,绑定到消息队列D  前缀匹配到topic. 即可接受
    @Bean
    Binding bindingExchangeMessage2(Queue queueD, TopicExchange exchange) {
        return BindingBuilder.bind(queueD).to(exchange).with("topic.#");
    }
}
