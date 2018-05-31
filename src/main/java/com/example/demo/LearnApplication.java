package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.crudRest")
@SpringBootApplication
public class LearnApplication {

	public static void main(String[] args) {
		
		org.springframework.context.ApplicationContext ctx = SpringApplication.run(LearnApplication.class, args);
	String[] beanNames=ctx.getBeanDefinitionNames();
	for(String beanName:beanNames) {
		System.out.println(beanName);
	}
	}
}
