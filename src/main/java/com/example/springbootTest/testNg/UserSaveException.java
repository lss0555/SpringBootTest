package com.example.springbootTest.testNg;

/**
 * @Description 保存用户异常
 * @Author lss0555
 * @Date 2018/12/21/021 16:28
 **/
public class UserSaveException extends RuntimeException {
    public UserSaveException(){
    }

    public UserSaveException(String msg){
        super(msg);
        System.out.println("异常信息:"+msg);
    }
}
