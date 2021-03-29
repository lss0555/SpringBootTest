package com.example.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CpuController  {

    private Object lock1=new Object();
    private Object lock2=new Object();

    /**
     * 死锁
     * @return
     */
    @GetMapping("deadlock")
    public String deadlock(){
        new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("Thread 1 over");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("Thread 2 over");
                }
            }
        }).start();
        return "dead locks";
    }
}
