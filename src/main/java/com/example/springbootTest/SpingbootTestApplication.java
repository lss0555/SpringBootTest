package com.example.springbootTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.springbootTest"})
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages  = "com.example.springbootTest.dao.mapper")
public class SpingbootTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpingbootTestApplication.class, args);
	}
}
