package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=LearnApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicControllerIntegrationTest {
	private static final String LOCAL_HOST="http://localhost:";
	
	@LocalServerPort
	private int port;
	
	private TestRestTemplate template= new TestRestTemplate();
	
	@Test
	public void welcome() {
		ResponseEntity<String> response=template.getForEntity(createURL("/welcome"), String.class);
		assertThat(response.getBody(),equalTo("Hello World"));
	}
	
	@Test
	public void welcomeWithObject() {
		ResponseEntity<String> response=template.getForEntity(createURL("/welcome-with-object"), String.class);
		assertThat(response.getBody(),containsString("Hello World"));
	}
	
	@Test
	public void welcomeWithParam() {
		ResponseEntity<String> response=template.getForEntity(createURL("/welcome-with-parameter/name/Nitin"), String.class);
		assertThat(response.getBody(),containsString("Nitin"));
	}
	
	
	private String createURL(String uri) {
		return LOCAL_HOST+port+uri;
	}
}
