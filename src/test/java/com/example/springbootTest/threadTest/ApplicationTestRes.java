//package com.example.springbootTest;
//
//import com.example.springbootTest.config.RedisDistributedLock;
//import com.example.springbootTest.rocks.RedisLock;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@SpringBootConfiguration
//@ComponentScan(basePackages = {"com.example.springbootTest"})
//@EnableAutoConfiguration
//@MapperScan(basePackages  = "com.example.springbootTest.dao.mapper")
//public class ApplicationTestRes {
//	private RedisLock lock=new RedisLock();
//
//	@Resource
//	RedisDistributedLock redisDistributedLock;
//
//	ExecutorService executorService=Executors.newCachedThreadPool();
//
//	private static int num;
//	@Test
//	public void buyTest() {
//		for (int i=0;i<10000;i++){
//			executorService.submit(new BuyTickRunable());
//		}
//	}
//	public class BuyTickRunable implements Runnable{
//		@Override
//		public void run() {
////			while (num>0){
//				lock.lock();
//				try {
////					if(num>0){
//					num++;
//						System.out.println("当前数字:"+num);
////					}
//				}catch (Exception e){
//					e.printStackTrace();
//				}finally {
//					lock.unlock();
//				}
////			}
//		}
//	}
//}
