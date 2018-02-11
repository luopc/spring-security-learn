package com.luopc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = {"com.luopc.base.**.dao"})
@EnableAutoConfiguration
public class MyShiroApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyShiroApplication.class, args);
	}

}
