package com.example.apitest.controller;

import com.example.apitest.dao.PagesDaoMapper;
import com.example.apitest.model.TResult;
import com.example.apitest.model.pages;
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
    @Resource
    PagesDaoMapper pagesDaoMapper;

    @GetMapping("/pageList")
    @CrossOrigin
    public TResult pageList(){
        TResult<pages> result = new TResult<>();
        result.setList(pagesDaoMapper.list());
        return result;
    }
}
