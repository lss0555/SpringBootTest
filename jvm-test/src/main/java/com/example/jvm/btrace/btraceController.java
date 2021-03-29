package com.example.jvm.btrace;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class btraceController {

    @GetMapping("getname")
    public String getName(@RequestParam("name")String name){
        return "my name is "+name;
    }
}
