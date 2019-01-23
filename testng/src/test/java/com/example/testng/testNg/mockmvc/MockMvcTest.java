package com.example.testng.testNg.mockmvc;

import com.example.testng.Controller.TestController;
import com.example.testng.model.User;
import com.example.testng.testNg.BaseTestNg;
import javafx.animation.Animation;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @Description mockTest
 * @Author lss0555
 * @Date 2019/1/23/023 15:56
 **/
public class MockMvcTest extends BaseTestNg{

    /**
     * @Description  get请求
     **/
    @Test(dataProvider = "num")
    public void testUser(int a) throws Exception {
        MvcResult result = mockMvc.perform(get("/hello")
        .param("a",a+""))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        Assert.assertNotNull(result);
    }

    /**
     * @Description  模拟post请求
     **/
    @Test(dataProvider = "users")
    public void testLogin(User user) throws Exception {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)  //数据的格式
                .param("username", user.getUsername()).param("password", user.getPassword()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
//====================================参数=======================================
    @DataProvider(name = "users")
    public Object[][] userList() {
        return new Object[][] { { new User("1","1")},
                { new User("2","2")},
                { new User("3","3")} };
    }

    @DataProvider(name = "num")
    public Object[][] provideData() {
        return new Object[][] { { 1}, { 2}, { 4} };
    }
}
