package com.example.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.redisson"})
@EnableAutoConfiguration
@SpringBootApplication
@SpringBootConfiguration
@EnableCaching //开启缓存功能
public class RedissonApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedissonApplication.class, args);
	}
}

