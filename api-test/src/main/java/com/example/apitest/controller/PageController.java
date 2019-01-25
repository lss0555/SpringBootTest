package com.example.apitest.controller;

import com.example.apitest.dao.PagesDaoMapper;
import com.example.apitest.model.TResult;
import com.example.apitest.model.pages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description page表数据
 * @Author lss0555
 * @Date 2019/1/24/024 16:18
 **/
@RestController
public class PageController {
    private Logger logger = LoggerFactory.getLogger(PageController.class);
    @Resource
    PagesDaoMapper pagesDaoMapper;

    @GetMapping("/pageList")
    @CrossOrigin
    public TResult pageList(){
        TResult<pages> result = new TResult<>();
        result.setRows(pagesDaoMapper.list());
        logger.info(pagesDaoMapper.list().toString());
        logger.info("logback info");
        logger.error("logback error");
        logger.debug("logback dubug");
        return result;
    }
}
