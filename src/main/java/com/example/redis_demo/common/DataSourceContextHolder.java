package com.example.redis_demo.common;

/**
 * Description 本地线程全局变量  <br/>
 */
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();
    public static final String DEFAULT_DS = "write";//默认数据源

    public static ThreadLocal<String> getLocal() {
        return local;
    }


    public static String getJdbcType() {
        return local.get();
    }

    public static void setJdbcType(String dbType) {
        local.set(dbType);
    }
    // 清除数据源名
    public static void clearDB() {
        local.remove();
    }
}
