package com.galaxy.spring.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.spring.vo.UserVO;

@RestController
@RequestMapping (path = RestConstants.URL_USERS_BASE)
public class UserController implements IController<UserVO> {

	@RequestMapping(method = RequestMethod.GET)
	@Override
	public Iterable<UserVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	@Override
	public Iterable<UserVO> save(UserVO userVO) throws DataIntegrityViolationException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@Override
	public void deleteById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(method = RequestMethod.GET, path = RestConstants.URL_USERS_FINDBYID)
	@Override
	public UserVO findById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
