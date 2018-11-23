package com.example.springbootTest.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Description 基础模型
 * @Author lss0555
 * @Date 2018/11/21/021 8:45
 **/
@Setter
@Getter
public class TResult<T> {
    private int errorCode;
    private T model;
    private List<T> list;

}
