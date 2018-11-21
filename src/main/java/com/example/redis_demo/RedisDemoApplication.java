package com.example.redis_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.redis_demo"})
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages  = "com.example.redis_demo.dao.mapper")
public class RedisDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
}
