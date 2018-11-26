package com.example.springbootTest.config;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Description redis实现类  <br/>
 */
@Service("redisService")
public class RedisServiceImpl implements RedisServiceInter {
    @Resource
    private RedisTemplate<String, ?> redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 1;

    //设置String类型
    @Override
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });
        return result;
    }

    //获取string类型
    @Override
    public String get(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value = connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    //设置时长
    @Override
    public boolean expire(final String key) {
        return redisTemplate.expire(key, TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
    }

    //移除key
    @Override
    public boolean remove(final String key) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.del(key.getBytes());
                return true;
            }
        });
        return result;
    }

    /**
     * 是否存在key * @param key * @return
     * @param key
     */
    @Override
    public boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }


    /**
     * @Author lss0555
     * @Description  存放hash
     **/
    @Override
    public boolean setHash(String key, HashMap<String, String> map) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                redisTemplate.opsForHash().putAll(key,map);
                connection.del(key.getBytes());
                return true;
            }
        });
        return result;
    }

    //获取hash
    @Override
    public Object getHash(String key,String ObjKey ) {
        return redisTemplate.opsForHash().get(key, ObjKey);
    }


    //设置list
    @Override

    //TODO  待处理
    public boolean setList(String key, List<Object> list) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                redisTemplate.opsForList().leftPushAll(key, (Collection)list);
                return true;
            }
        });
        return false;
    }


    //获取集合列表
    @Override
    public List<Object> getList(String key) {
        List<Object> range = (List<Object>) redisTemplate.opsForList().range(key, 0, -1);
        return range;
    }


}
