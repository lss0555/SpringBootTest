package com.example.mybatispaging.dao;


import com.example.mybatispaging.model.pages;

import java.util.List;

/**
 * @Description 分页数据
 **/
public interface PagesDaoMapper {
    List<pages> list();
}
