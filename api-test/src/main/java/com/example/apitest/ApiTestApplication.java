package com.example.apitest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.apitest"})
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages  = "com.example.apitest.dao")
public class ApiTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}
}

