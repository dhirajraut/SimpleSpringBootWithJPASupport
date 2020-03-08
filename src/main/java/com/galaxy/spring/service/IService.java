package com.galaxy.spring.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;

public interface IService<T> {
	/**
	 * Returns all objects.
	 * 
	 * @return
	 */
	public Iterable<T> findAll();

	/**
	 * Creates new objects.
	 * 
	 * @param user
	 * @return
	 * @throws ConstraintsViolationException
	 */
	public Iterable<T> saveAll(Iterable<T> objects) throws DataIntegrityViolationException, EntityNotFoundException;

	/**
	 * Deletes an object.
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	public void deleteById(long id) throws EntityNotFoundException;

	/**
	 * Finds object by id.
	 * 
	 * @param id
	 * @return
	 * @throws EntityNotFoundException
	 */
	public T findById(long id) throws EntityNotFoundException;
}
