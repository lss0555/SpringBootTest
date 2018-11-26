package com.example.springbootTest.config;

import java.util.HashMap;
import java.util.List;

/**
 * Description redis接口类  <br/>
 */
public interface RedisServiceInter {
    /**
     * set存数据 * @param key * @param value * @return
     */
    boolean set(String key, String value);

    /**
     * get获取数据 * @param key * @return
     */
    String get(String key);

    /**
     * 设置有效小时 * @param key * @param expire * @return
     */
    boolean expire(String key);

    /**
     * 移除数据 * @param key * @return
     */
    boolean remove(String key);

    /**
     * 是否存在key * @param key * @return
     */
    boolean hasKey(String key);


    boolean setHash(String key, HashMap<String,String> map);

    Object getHash(String key,String ObjKey);

    boolean setList(String key, List<Object> list);

    List<Object> getList(String key);

}
