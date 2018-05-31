package com.example.crudRest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.LearnApplication;

import static org.mockito.Matchers.anyString;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes=LearnApplication.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private TodoService todoService;
	
	@Test
	public void retrieveTodos() {
		List<Todo> mockList=Arrays.asList(new Todo(1,"Jack","Learn Spring",new Date(),false));
	
	when(todoService.retrieveTodos(org.mockito.Matchers.anyString())).thenReturn(mockList);
	
	MvcResult result = null;
	try {
		result = mvc.perform(MockMvcRequestBuilders.get("users/Jack/todos").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String expected="[{id:1,user:Jack,desc:Learn Spring,done:false}]";
	try {
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
	} catch (UnsupportedEncodingException | JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
}
