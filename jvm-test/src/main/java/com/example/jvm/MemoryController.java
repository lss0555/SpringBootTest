package com.example.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * 测试内存溢出
 */
@RestController
public class MemoryController {

    private ArrayList<String> mList=new ArrayList<>();

    @GetMapping(value = "memoryheap")
    public String memoryHeap(){
        while (true){
            mList.add(""+System.currentTimeMillis());
        }
    }

}
