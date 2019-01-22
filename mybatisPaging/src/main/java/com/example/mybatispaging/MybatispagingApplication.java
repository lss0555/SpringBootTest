package com.example.mybatispaging;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.mybatispaging"})
@EnableAutoConfiguration
@SpringBootApplication
@MapperScan(basePackages  = "com.example.mybatispaging.dao")
public class MybatispagingApplication {
	public static void main(String[] args) {
		SpringApplication.run(MybatispagingApplication.class, args);
	}

}

