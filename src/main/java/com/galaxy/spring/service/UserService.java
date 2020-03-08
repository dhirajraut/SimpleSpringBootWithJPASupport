package com.galaxy.spring.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.galaxy.spring.entities.UserEntity;
import com.galaxy.spring.jpa.IUserRepository;
import com.galaxy.spring.vo.UserVO;
import com.google.common.reflect.TypeToken;

@Service
public class UserService implements IService<UserVO> {

	@Autowired
	IUserRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public Iterable<UserVO> findAll() {
		List<UserEntity> userEntityList = repository.findAll();
		List<UserVO> userVOList = modelMapper.map(userEntityList, new TypeToken<List<UserVO>>() {
		}.getType());
		return userVOList;
	}

	@Override
	public Iterable<UserVO> saveAll(Iterable<UserVO> userVOList)
			throws DataIntegrityViolationException, EntityNotFoundException {
		Iterable<UserEntity> userEntityList = modelMapper.map(userVOList, new TypeToken<List<UserEntity>>() {}.getType());
		Iterable<UserEntity> savedEntities = repository.saveAll(userEntityList);
		Iterable<UserVO> savedUserVOList = modelMapper.map(savedEntities, new TypeToken<List<UserVO>>() {}.getType());
		return savedUserVOList;
	}

	@Override
	public void deleteById(long id) throws EntityNotFoundException {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Couldn't find Entity");
		}
	}

	@Override
	public UserVO findById(long id) throws EntityNotFoundException {
		UserEntity userEntity = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Couldn't find Entity"));
		UserVO userVO = modelMapper.map(userEntity, UserVO.class);
		return userVO;
	}

}
