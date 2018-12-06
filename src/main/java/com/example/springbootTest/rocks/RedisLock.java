package com.example.springbootTest.rocks;

import com.example.springbootTest.config.RedisDistributedLock;
import com.example.springbootTest.config.RedisServiceInter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description redis分布式锁
 * @Author lss0555
 **/
@Component
public class RedisLock implements Lock {
    private Logger logger = LoggerFactory.getLogger(RedisLock.class);
    public static final String UNLOCK_LUA;
    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    @Resource
    RedisServiceInter redisServiceInter;

    private static  final  String  KEY="KEY";

    private ThreadLocal<String> local=new ThreadLocal<>();

    //加锁
    @Override
    public void lock() {
        //1.尝试加锁
        if(tryLock()){
            return;
        }
        //2.加锁失败 当前任务休眠一段时间
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        //3.递归调用,再次重新加锁
        lock();
    }


    //尝试加锁
    @Override
    public boolean tryLock() {
        //产生随机值
        String uuid=UUID.randomUUID().toString();
        //设置随机值以及设置失效时间
        boolean ret = redisServiceInter.setNx(KEY, uuid, 100);
        if(ret){
            //加锁成功后,为当前threadlocal设置随机值,以便解锁的时候使用
            local.set(uuid);
        }
        return ret;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    //解锁
    @Override
    public void unlock() {
        boolean b = redisServiceInter.releaseLock(KEY, local.get());
        //清理ThreadLocal中的数据,避免内存溢出
        local.remove();
        if(!b){
            logger.error("解锁失败");
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
