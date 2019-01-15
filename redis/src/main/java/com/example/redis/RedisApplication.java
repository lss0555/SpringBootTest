package com.example.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.redis"})
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@MapperScan(basePackages  = "com.example.redis.user.dao")
public class RedisApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}
}

