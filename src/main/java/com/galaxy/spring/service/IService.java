package com.galaxy.spring.service;


import com.galaxy.spring.exceptions.EntityNotFoundException;
import com.galaxy.spring.exceptions.IntegrityViolationException;

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
	public Iterable<T> saveAll(Iterable<T> objects) throws IntegrityViolationException, EntityNotFoundException;

	/**
	 * Deletes an object.
	 * 
	 * @param id
	 * @throws EntityNotFoundException
	 */
	public void deleteById(Long id) throws EntityNotFoundException;

	/**
	 * Finds object by id.
	 * 
	 * @param id
	 * @return
	 * @throws EntityNotFoundException
	 */
	public T findById(Long id) throws EntityNotFoundException;
}
