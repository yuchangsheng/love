package com.changsheng.love;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.changsheng.core.db")
@ComponentScan(basePackages = "com.changsheng.love")
public class LoveApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoveApplication.class, args);
	}
}
