package com.example.springbootTest.service.inter;

import com.example.springbootTest.model.TResult;
import com.example.springbootTest.model.User;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Author lss0555
 **/
public interface DeferredResultServiceInter {
    TResult login();
    void login1(DeferredResult<TResult<User>> deferredResult);
}
