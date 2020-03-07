package com.galaxy.spring.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

import com.galaxy.spring.vo.UserVO;

public class UserService implements IService<UserVO> {

	@Override
	public Iterable<UserVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserVO> save(UserVO id) throws DataIntegrityViolationException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public UserVO findById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
