package com.example.mybatistest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description test
 * @Author lss0555
 * @Date 2019/2/18/018 14:33
 **/
@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("test1")
    public String test1(){
        logger.debug("testcontroller:dubug");
        logger.info("testcontroller:info");
        logger.error("testcontroller:error");
        logger.warn("testcontroller:warn");
        return "test1";
    }


    @GetMapping("test2")
    public String test2(){
        return "test2";
    }

}
