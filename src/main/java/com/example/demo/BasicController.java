package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
private static final String template="Hello World,%s!";
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Hello World";
	}
	
	@GetMapping("/welcome-with-object")
	public WelcomeBean welcomeWithObject() {
		return new WelcomeBean("Hello World!");
	}
	
	@GetMapping("/welcome-with-parameter/name/{name}")
	public WelcomeBean welcomeWithParam(@PathVariable String name) {
		return new WelcomeBean(String.format(template, name));
	}
}
