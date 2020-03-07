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
	 * Creates a new object.
	 * 
	 * @param user
	 * @return
	 * @throws ConstraintsViolationException
	 */
	public Iterable<T> save(T object) throws DataIntegrityViolationException, EntityNotFoundException;

	/**
	 * Deletes an object.
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	public void deleteById(int id) throws EntityNotFoundException;

	/**
	 * Finds object by id.
	 * 
	 * @param id
	 * @return
	 * @throws EntityNotFoundException
	 */
	public T findById(int id) throws EntityNotFoundException;
}
