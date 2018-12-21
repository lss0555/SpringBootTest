package com.example.springbootTest.testNg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description hello
 * @Author lss0555
 * @Date 2018/12/20/020 14:50
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello =>");
        return "hello world";
    }
}
