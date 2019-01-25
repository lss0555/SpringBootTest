package com.example.apitest.model;

import java.util.List;

/**
 * @Description 基础模型
 **/
public class TResult<T> {
    private int errorCode;
    private T model;
    private List<T> list;
    private List<T> rows;

    public TResult<T> tResult(T t, int errorCode, List<T> list) {
        TResult<T> result = new TResult<>();
        result.setModel(t);
        result.setErrorCode(errorCode);
        result.setList(list);
        return result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TResult{" +
                "errorCode=" + errorCode +
                ", model=" + model +
                ", list=" + list +
                '}';
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
