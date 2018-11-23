package com.example.springbootTest.common.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

//动态选择datesourece
public class MyAbstractRoutingDataSource extends AbstractRoutingDataSource {
    //配置的读库数量
    private final int dataSourceNumber;
    private AtomicInteger count = new AtomicInteger(0);
    /**
    * @dataSourceNumber  从库的数量
    **/
    public MyAbstractRoutingDataSource(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }
    @Override
    protected Object determineCurrentLookupKey() {
        //获取通过aop设置的数据源名称
        String typeKey = DataSourceContextHolder.getJdbcType();
        //如果是当前数据源是默认主库,直接返回主库
        if (typeKey.equals(DataSourceType.write.getType())){
            return DataSourceType.write.getType();
        }
        //从库     读 简单负载均衡
//        int number = count.getAndAdd(1);
//        int lookupKey = number % dataSourceNumber;
//        return new Integer(lookupKey);

        if(typeKey.equals("read1")){
            return 0;
        }
        if(typeKey.equals("read2")){
            return 1;
        }
        return 0;
    }
}
