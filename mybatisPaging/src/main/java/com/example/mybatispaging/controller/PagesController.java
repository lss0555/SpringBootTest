package com.example.mybatispaging.controller;

import com.example.mybatispaging.dao.PagesDaoMapper;
import com.example.mybatispaging.model.TResult;
import com.example.mybatispaging.model.pages;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 分页测试
 * @Author lss0555
 * @Date 2019/1/16/016 10:27
 **/
@RestController
public class PagesController {
    @Resource
    PagesDaoMapper pagesDaoMapper;

    @GetMapping("/list")
    public TResult pageList(Integer currentPage, Integer pageSize){
        // 必须在mapper接口中的方法执行之前设置该分页信息
        currentPage = currentPage == null || currentPage<= 0 ? 1:currentPage;
        pageSize = pageSize == null || pageSize<= 0 ? 10:pageSize;
        //执行分页操作
        PageHelper.startPage(currentPage, pageSize);
        //查询数据库数据
        List<pages> list = pagesDaoMapper.list();//全部商品
        return new TResult().setList(list);
    }
}
