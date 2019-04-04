package com.example.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.wx"})
@EnableAutoConfiguration
@ServletComponentScan
@SpringBootApplication
public class WxApplication {
	public static void main(String[] args) {
		SpringApplication.run(WxApplication.class, args);
	}

}
