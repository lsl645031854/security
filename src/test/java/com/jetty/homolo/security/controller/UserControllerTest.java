package com.jetty.homolo.security.controller;

import com.jetty.homolo.security.entity.Shoe;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-09-09  下午6:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); //建议使用这种
	}

	@Test
	public void getHello() throws Exception {
        String shoesString = list2String();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.param("username", "rose")
				.param("password", "123456")
				.param("shoes", new Shoe("red", 42).toString(),
                        new Shoe("black", 41).toString())
//                .content()
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		System.out.println(mvcResult.getResponse().getStatus());
		System.out.println(mvcResult.getResponse().getContentAsString());
	}

	private String list2String() {
        List<Shoe> list = new ArrayList<>();
        Shoe shoe = new Shoe("red", 42);
        Shoe shoe1 = new Shoe("black", 41);
        list.add(shoe);
        list.add(shoe1);
        return list.toString();
	}
}
