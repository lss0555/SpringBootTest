package com.example.testng.Controller;

import com.example.testng.model.TResult;
import com.example.testng.model.User;
import org.springframework.stereotype.Service;

/**
 * @Author lss0555
 * @Date 2018/12/21/021 16:25
 **/
@Service
public class UserService {
    public TResult saveUser(User user){
        if (user == null) {
            throw new UserSaveException("user is empty!");
        }
        return null;
    }
}
