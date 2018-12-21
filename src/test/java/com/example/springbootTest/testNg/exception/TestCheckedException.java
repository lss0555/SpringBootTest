package com.example.springbootTest.testNg.exception;

import com.example.springbootTest.testNg.BaseTestNg;
import com.example.springbootTest.testNg.UserNgController;
import com.example.springbootTest.testNg.UserSaveException;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @Description 检查异常
 * @Author lss0555
 * @Date 2018/12/21/021 16:34
 **/
public class TestCheckedException extends BaseTestNg{

    @Resource
    UserNgController userNgController;


    @Test(expectedExceptions = UserSaveException.class)
    public void throwIfUserIsNull() throws UserSaveException {
        userNgController.saveUser(null);
    }
}
