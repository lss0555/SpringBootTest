package com.example.springbootTest.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootTest.common.aop.LogAspect;
import com.example.springbootTest.config.RedisServiceInter;
import com.example.springbootTest.model.User;
import com.example.springbootTest.rocks.RedisLock;
import com.example.springbootTest.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.newCachedThreadPool;
import static org.apache.coyote.http11.Constants.a;

/**
 * @Description redis操作测试
 * @Author lss0555
 * @Date 2018/11/26/026 10:35
 **/
@RestController
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(RedisController.class);
    @Resource
    private RedisServiceInter redisService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取字符串
     */
    @GetMapping("/setStr")
    public String setString() {
        boolean a=redisService.set("redis_string_test", "lss0555");
        return ""+a;
    }

    /**
     * 获取字符串
     */
    @GetMapping("/getStr")
    public String getString() {
        String result = (String) redisService.get("redis_string_test");
        System.out.println(result);
        return result;
    }

    /**
     * 插入对象
     */
    @GetMapping("/setObj")
    public String setObject() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        User user = new User("ssss", "aaaa");
        boolean a=redisService.set("redis_obj_user", user);
        return  ""+a;
    }

    /**
     * 获取对象
     */
    @GetMapping("/getObj")
    public String getObject() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        User result = (User) redisService.get("redis_obj_user");
        return result.toString();
    }

    /**
     * 插入对象List
     */
    @GetMapping("/setObjList")
    public String setList() {
        User user = new User("1", "1");
        User user1 = new User("2", "22");
        User user2 = new User("3", "33");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        boolean a=redisService.set("redis_list_user", list);
        return ""+a;
    }

    /**
     * 获取list
     */
    @GetMapping("/getObjList")
    public String getList() {
        List<User> result =(List<User>) redisService.get("redis_list_user");
        return result.toString();
    }

    @GetMapping("/remove")
    public String remove() {
        redisService.delKey("redis_list_user");
        return  "";
    }


    @GetMapping("/setHash")
    public String setHash() {
        HashMap<String,Object> map=new HashMap<>();
        map.put("name","lss0555");
        map.put("password","12345");
        boolean a= redisService.hmset("hash",map);
        return  a+"";
    }

    @GetMapping("/getHash")
    public String getHash() {
        String name= (String) redisService.hget("hash","name");
        return  name;
    }

    @GetMapping("/setLists")
    public String setLists() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        User user = new User("1", "1");
        User user1 = new User("2", "22");
        User user2 = new User("3", "33");
        List<Object> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        boolean a=redisService.lSet("list",list);
        return  ""+a;
    }

    @GetMapping("/getListss")
    public String getListss() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        List<Object> list = redisService.lGet("list",0,-1);
        return  list.toString();
    }


    @GetMapping("/lSetList")
    public String lSetList() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        User user = new User("1", "1");
        User user1 = new User("2", "22");
        User user2 = new User("3", "33");
        List<Object> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);

        boolean a=redisService.lSet("lss1",list);
        return  a+"";
    }

    @GetMapping("/lSetListAdd")
    public String lSetListAdd() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        User user = new User("444", "4444");
        List<Object> list = new ArrayList<>();
        list.add(user);

        boolean a=redisService.lSet("lss1",list);
        return  a+"";
    }

    //获取list
    @GetMapping("/lGetList")
    public String lGetList() {
        redisTemplate.setKeySerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        List<Object> lss1 =redisService.lGet("lss1", 0, -1);
        return  lss1.toString();
    }


    //计数  原子性
    @GetMapping("/numCount")
    public String numCount(){
        String key="count";
        redisTemplate.setKeySerializer(new GenericToStringSerializer<String>(String.class));
        redisTemplate.setValueSerializer(new GenericToStringSerializer<String>(String.class));
        redisService.set(key,(Integer)1);
        ExecutorService executors=Executors.newCachedThreadPool();
        for (int i=0;i<1000;i++){
            executors.execute(new Runnable() {
                @Override
                public void run() {
                    redisService.incr(key,1);
                    System.out.println("结果:"+redisService.get(key));
                }
            });
        }
        executors.shutdown();
        return (String) redisService.get(key);
    }

}
