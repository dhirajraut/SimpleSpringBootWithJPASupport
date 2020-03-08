package com.galaxy.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.galaxy.spring.vo.UserVO;

@WebAppConfiguration
public class AbstractControllerTest {

	protected MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected void setUp(IController<UserVO> controller) {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

}
