package com.galaxy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import com.galaxy.spring.controller.UserController;
import com.galaxy.spring.service.UserService;
import com.galaxy.spring.vo.UserVO;

@Transactional
public class UserControllerTest extends AbstractControllerTest {

	@Mock
	UserService userService; // Service to mock.
	
	@InjectMocks
	UserController userController; // Controller where the mocks to be injected.
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setUp(userController);
	}
	
	/**
	 * Mock data generator.
	 * @param numberOfObjectsRequired
	 * @return
	 */
	private List<UserVO> getUserMockData(int numberOfObjectsRequired) {

		/* Create dummy user object. */
		List<UserVO> userList = new ArrayList<UserVO>();
		for (int counter = 1; counter <= numberOfObjectsRequired; counter++) {
			UserVO user = new UserVO();
			user.setFirstName("Sharon" + counter);
			user.setLastName("Shelly");
			user.setEmail("sharon.shelly@somecompany.com");
			userList.add(user);
		}
		return userList;
	}
	
	/**
	 * Test for GetAll
	 * @throws Exception
	 */
	@Test
	public void testGetAll() throws Exception {
		Mockito.when(userService.findAll()).thenReturn(getUserMockData(3));
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.ALL)).andReturn();
		String contents = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Mockito.verify(userService, Mockito.times(1)).findAll();
		
		Assert.isTrue(HttpStatus.OK.value() == status, "Failure - Unable to get 200 status");
		Assert.notNull(contents, "Failure - Unable to get contents");
		Assert.isTrue(contents.length() > 0, "Failure - Unable to get contents size > 0");
	}
	
	/**
	 * Test Get specific
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUserGet() throws Exception {
		List<UserVO> userMockDataList = getUserMockData(1);
		UserVO mockUser = (UserVO) ((List<UserVO>) userMockDataList).get(0);
		Mockito.when(userService.findById(Mockito.anyLong())).thenReturn(mockUser);

		String uri = "/users/1";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.ALL)).andReturn();
		String contents = mvcResult.getResponse().getContentAsString();
		int status = mvcResult.getResponse().getStatus();
		Mockito.verify(userService, Mockito.times(1)).findById(Mockito.anyLong());

		Assert.isTrue(HttpStatus.OK.value() == status, "Failure - Unable to get 200 status");
		Assert.notNull(contents, "Failure - Unable to get contents");
		Assert.isTrue(contents.length() > 0, "Failure - Unable to get contents size > 0");
	}

	/**
	 * Test delete specific.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testUserDelete() throws Exception {
		Mockito.doNothing().when(userService).deleteById(1L);

		String uri = "/users/1";
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri).accept(MediaType.ALL)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Mockito.verify(userService, Mockito.times(1)).deleteById(Mockito.anyLong());

		Assert.isTrue(HttpStatus.OK.value() == status, "Failure - Unable to get 200 status");
	}
	
	@Test
    public void testUserPost() throws Exception
    {
        Iterable<UserVO> userMockDataList = getUserMockData(1);

        Mockito.when(userService.saveAll(Mockito.any(ArrayList.class))).thenReturn(userMockDataList);

        String uri = "/users";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri, userMockDataList).contentType(MediaType.APPLICATION_JSON).content("")).andReturn();
        String contents = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        Mockito.verify(userService, Mockito.times(1)).saveAll(Mockito.any(ArrayList.class));

        Assert.isTrue(HttpStatus.CREATED.value() == status, "Failure - Unable to get 201 status");
        Assert.notNull(contents, "Failure - Unable to get contents");
        Assert.isTrue(contents.length() > 0, "Failure - Unable to get contents size > 0");
    }
}
