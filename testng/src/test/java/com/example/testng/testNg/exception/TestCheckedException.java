package com.example.testng.testNg.exception;

import com.example.testng.Controller.UserNgController;
import com.example.testng.Controller.UserSaveException;
import com.example.testng.testNg.BaseTestNg;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * @Description 检查异常
 * @Author lss0555
 * @Date 2018/12/21/021 16:34
 **/
public class TestCheckedException extends BaseTestNg {

    @Resource
    UserNgController userNgController;


    @Test(expectedExceptions = UserSaveException.class)
    public void throwIfUserIsNull() throws UserSaveException {
        userNgController.saveUser(null);
    }
}
