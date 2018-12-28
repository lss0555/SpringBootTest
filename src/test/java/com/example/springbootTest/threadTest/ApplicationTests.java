//package com.example.redis_demo;
//
//import com.example.springbootTest.dao.inter.UserDaoInter;
//import com.example.springbootTest.model.TResult;
//import com.example.springbootTest.model.User;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@SpringBootConfiguration
////@ComponentScan(basePackages = {"com.example.springbootTest"})
////@EnableAutoConfiguration
////@MapperScan(basePackages  = "com.example.springbootTest.dao.mapper")
//public class ApplicationTests {
//	ExecutorService executorService=Executors.newCachedThreadPool();
//	Lock lock=new ReentrantLock();
//	private static  int TicketNum=100;
//	@Test
//	public void buyTest() {
//		for (int i=0;i<200;i++){
//			executorService.submit(new Runnable() {
//				@Override
//				public void run() {
//					buyTicket();
//				}
//			});
//		}
//	}
//
//	private void buyTicket() {
//		while (TicketNum>0){
//			try {
//				lock.lock();
//				System.out.println("当前抢到第:"+TicketNum+"张票");
//				TicketNum--;
//			}catch (Exception e){
//
//			}finally {
//				lock.unlock();
//			}
//		}
//	}
//
//	public void getLock(){
//		long end = UUID.randomUUID().timestamp();
//		while (System.currentTimeMillis()<end){//阻塞
//		}
//	}
//}
