package com.galaxy.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.spring.exceptions.EntityNotFoundException;
import com.galaxy.spring.exceptions.IntegrityViolationException;
import com.galaxy.spring.service.UserService;
import com.galaxy.spring.vo.UserVO;

@RestController
@RequestMapping(path = RestConstants.URL_USERS_BASE)
public class UserController implements IController<UserVO> {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public Iterable<UserVO> findAll() {
		return userService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public Iterable<UserVO> save(UserVO userVO) throws IntegrityViolationException, EntityNotFoundException {
		List<UserVO> userVOList = new ArrayList<UserVO>();
		userVOList.add(userVO);
		return userService.saveAll(userVOList);
	}

	// @RequestMapping(method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// @Override
	// @TODO
	public Iterable<UserVO> saveAll(Iterable<UserVO> userVOList)
			throws IntegrityViolationException, EntityNotFoundException {
		return userService.saveAll(userVOList);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = RestConstants.URL_USERS_FINDBYID)
	@Override
	public void deleteById(/* Variable in URL path */ @PathVariable Long id) throws EntityNotFoundException {
		userService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = RestConstants.URL_USERS_FINDBYID)
	@Override
	public UserVO findById(/* Variable in URL path */ @PathVariable Long id) throws EntityNotFoundException {
		return userService.findById(id);
	}

}
