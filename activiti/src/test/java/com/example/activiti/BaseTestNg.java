package com.example.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

/**
 * @Description 基类
 * @Author lss0555
 * @Date 2019/4/15/015 9:51
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTestNg extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;

    public MockMvc mockMvc;

    @BeforeClass
    public void setUp() {
        //创建一个MockMvc进行测试
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}