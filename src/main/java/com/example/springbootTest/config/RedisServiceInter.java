package com.example.springbootTest.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description redis接口类  <br/>
 */
public interface RedisServiceInter {
    //指定缓存失效时间
    boolean expire(String key,long time);
    //根据key 获取过期时间
    long getExpire(String key);

    //判断key是否存在
    boolean hasKey(String key);

    //删除缓存
    void delKey(String ... key);

    //普通缓存放入
    boolean set(String key,Object value);
    //普通缓存获取
    Object get(String key);
    //普通缓存放入并设置时间
    boolean set(String key,Object value,long time);
    //递增 delta要大于0
    long incr(String key, long delta);
    //递减
    long decr(String key, long delta);

    //hash  操作
    boolean hmset(String key, Map<String,Object> map);
    //通过key获取map集合
    Map<Object,Object> hmget(String key);
    //通过key item获取
    Object hget(String key,String item);
    //hash  设置key,map,时间
    boolean hmset(String key, Map<String,Object> map, long time);
    boolean hset(String key,String item,Object value);
    boolean hset(String key,String item,Object value,long time);
    void hdel(String key, Object... item);
    //判断有误存在该key,value
    boolean hHasKey(String key, String item);
    //hash递增 如果不存在,就会创建一个 并把新增后的值返回
    double hincr(String key, String item,double by);
    //hash递减
    double hdecr(String key, String item,double by);


    //set  操作
    //获取key的set
    Set<Object> sGet(String key);
    //根据value从一个set中查询,是否存在
    boolean sHasKey(String key,Object value);
    //将数据放入set缓存
    long sSet(String key, Object...values);
    long sSetAndTime(String key,long time,Object...values);
    long sGetSetSize(String key);
    long setRemove(String key, Object ...values);


    //list操作
    List<Object> lGet(String key, long start, long end);
    long lGetListSize(String key);
    //将list放入缓存
    boolean lSet(String key, Object value);
    //将list放入缓存.并设置时间
    boolean lSet(String key, Object value, long time);
    boolean lSet(String key, List<Object> value);
    boolean lSet(String key, List<Object> value, long time);
    Object lGetIndex(String key,long index);
    boolean lUpdateIndex(String key, long index,Object value);
    long lRemove(String key,long count,Object value);

    boolean setNx(String key,String value,long time);
    String getNx(String key);
    boolean releaseLock(String key,String value);//lu脚本
}
