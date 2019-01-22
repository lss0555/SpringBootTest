//package com.example.mybatispaging.config;
//
//import com.github.pagehelper.PageHelper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.Properties;
//
///**
// * @Description 分页配置
// * @Author lss0555
// * @Date 2019/1/16/016 10:46
// **/
//@Component
//public class PageHelperConfig {
//    //配置mybatis的分页插件pageHelper
//    @Bean
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        //reasonable 启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页；
//        properties.setProperty("reasonable","false");
//        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
//}
