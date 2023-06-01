package com.example.myTGbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class MyTGbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTGbotApplication.class, args);
	}

}
