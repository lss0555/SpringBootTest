package com.example.springbootTest.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootTest.config.RedisServiceInter;
import com.example.springbootTest.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

/**
 * @Description redis操作测试
 * @Author lss0555
 * @Date 2018/11/26/026 10:35
 **/
@RestController
public class RedisController {
    @Resource
    private RedisServiceInter redisService;

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
        String result = redisService.get("redis_string_test");
        System.out.println(result);
        return result;
    }

    /**
     * 插入对象
     */
    @GetMapping("/setObj")
    public String setObject() {
        User user = new User("ssss", "aaaa");
        boolean a=redisService.set("redis_obj_user", JSON.toJSONString(user));
        return  ""+a;
    }

    /**
     * 获取对象
     */
    @GetMapping("/getObj")
    public String getObject() {
        String result = redisService.get("redis_obj_user");
        User user = JSON.parseObject(result, User.class);
        System.out.println(JSON.toJSONString(user));
        return JSON.toJSONString(user);
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
        boolean a=redisService.set("redis_list_user", JSON.toJSONString(list));
        return ""+a;
    }

    /**
     * 获取list
     */
    @GetMapping("/getObjList")
    public String getList() {
        String result = redisService.get("redis_list_user");
        List<String> list = JSON.parseArray(result, String.class);
        System.out.println(list);
        return list.toString();
    }

    @GetMapping("/remove")
    public String remove() {
        boolean a= redisService.remove("redis_list_user");
        return  a+"";
    }


    @GetMapping("/setHash")
    public String setHash() {
        HashMap<String,String> map=new HashMap<>();
        map.put("name","lss0555");
        map.put("password","12345");
        boolean a= redisService.setHash("hash",map);
        return  a+"";
    }

    @GetMapping("/getHash")
    public String getHash() {
        String name= (String) redisService.getHash("hash","name");
        return  name;
    }

    @GetMapping("/setLists")
    public String setLists() {
        User user = new User("1", "1");
        User user1 = new User("2", "22");
        User user2 = new User("3", "33");
        List<Object> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        boolean a=redisService.setList("list",list);
        return  ""+a;
    }

    @GetMapping("/getListss")
    public String getListss() {
        List<Object> list = redisService.getList("list");
        return  list.toString();
    }
}
