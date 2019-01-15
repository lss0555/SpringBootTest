package com.example.multisource;
import com.example.multisource.dynamic.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.example.multisource"})
@EnableAutoConfiguration
@SpringBootApplication
@Import({DynamicDataSourceRegister.class}) //注册多源数据库
@EnableCaching //开启缓存功能
@MapperScan(basePackages  = "com.example.multisource.dao")
public class MultisourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultisourceApplication.class, args);
	}

}

