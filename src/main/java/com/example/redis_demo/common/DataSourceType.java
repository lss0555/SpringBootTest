package com.example.redis_demo.common;

import lombok.Getter;

/**
 * Description 枚举区分读写库  <br/>
 * Author stream <br/>
 *
 * @Date 2018-08-10 9:16<br/>
 * @Version 1.0<br/>
 */
public enum  DataSourceType {
    read("read", "从库"),
    write("write", "主库");
    @Getter
    private String type;
    @Getter
    private String name;

    DataSourceType(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
