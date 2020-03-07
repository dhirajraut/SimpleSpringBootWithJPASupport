package com.galaxy.spring.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.galaxy.spring.entities.UserEntity;
import com.galaxy.spring.jpa.IUserDAO;
import com.galaxy.spring.vo.UserVO;

@Service
public class UserService implements IService<UserVO> {
	
	@Autowired
	IUserDAO repository;

	@Override
	public Iterable<UserVO> findAll() {
		List<UserEntity> findAll = repository.findAll();
		System.out.println(findAll);
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
