package com.example.springbootTest.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootTest.model.TResult;
import com.example.springbootTest.model.User;
import com.example.springbootTest.service.inter.DeferredResultServiceInter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author lss0555
 * @Date 2018/11/23/023 10:49
 **/
@Service
public class DeferredResultServiceImpl implements DeferredResultServiceInter {
    @Override
    public TResult login() {
        TResult<User> result = new TResult<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setPassword("123");
        user.setUsername("456");
        result.setModel(user);
        return result;
    }

    @Override
    public void login1(DeferredResult<TResult<User>> deferredResult) {
        TResult<User> result = new TResult<>();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setPassword("123");
        user.setUsername("456");
        result.setModel(user);
        String jsonString = JSONObject.toJSONString(result);

        deferredResult.setResult(result);
    }
}
