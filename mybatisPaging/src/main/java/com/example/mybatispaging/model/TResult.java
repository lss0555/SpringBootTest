package com.example.mybatispaging.model;

import java.util.List;

/**
 * @Description 模型基类
 * @Author lss0555
 * @Date 2019/1/22/022 8:43
 **/
public class TResult<T> {
    private int errorCode=0;
    private T model;
    private List<T> list;

    public TResult<T> setList(List<T> list){
        this.list=list;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public TResult setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public T getModel() {
        return model;
    }

    public TResult setModel(T model) {
        this.model = model;
        return this;
    }

    public List<T> getList() {
        return list;
    }

}
