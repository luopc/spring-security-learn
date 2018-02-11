package com.luopc.web.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void wenquerySuccess() throws Exception {
		String rs = mockMvc.perform(get("/user")
				.param("userName", "lisi")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
				.andReturn().getResponse().getContentAsString();
		System.out.println(rs);
	}
	
	@Test
	public void whenGetInfoSuccess() throws Exception {
		String rs = mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("TOM"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(rs);
	}

	@Test
	public void wenGetInfoFail() throws Exception {
		mockMvc.perform(get("/user/a").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().is4xxClientError());
	}
	
	@Test
	public void wenCreateSuccess() throws Exception {
		String cont = "{\"userName\":\"TOM\",\"credits\":10,\"lastVisit\":"+new Date().getTime()+"}";
		String rs = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(cont))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("1")).andReturn().getResponse().getContentAsString();
		System.out.println(rs);
	}
	
	@Test
	public void wenUpdateSuccess() throws Exception {
		String cont = "{\"userId\":\"1001\",\"userName\":\"TOM\",\"credits\":10,\"lastVisit\":"+new Date().getTime()+"}";
		String rs = mockMvc.perform(put("/user/1001").contentType(MediaType.APPLICATION_JSON_UTF8).content(cont))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("1001")).andReturn().getResponse().getContentAsString();
		System.out.println(rs);
	}
	
	@Test
	public void wenDeleteSuccess() throws Exception {
		String rs = mockMvc.perform(delete("/user/1001").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println(rs);
	}

	
	@Test
	public void wenUploadSuccess() throws UnsupportedEncodingException, Exception {
		String rs = mockMvc.perform(fileUpload("/file")
				.file(new MockMultipartFile("file", "test.txt","multipart/form-data","hello upload".getBytes("utf-8"))))
			.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}
	
	@Test
	public void wenDownSuccess() throws UnsupportedEncodingException, Exception {
		String rs = mockMvc.perform(get("/file/1517153065607"))
			.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}
	
	@Test
	public void randomTest() {
		Random r = new Random();
//		System.out.println(String.valueOf(((int)r.nextInt(1000))));
		
		System.out.println(RandomStringUtils.randomNumeric(6));
	}
	
}
