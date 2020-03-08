package com.galaxy.spring.controller;

import org.springframework.web.bind.annotation.RestController;

import com.galaxy.spring.exceptions.IntegrityViolationException;
import com.galaxy.spring.exceptions.EntityNotFoundException;

/**
 * Common interface for all controllers in Tea Store.
 */
@RestController
public interface IController<T> {

	

	/**
	 * Returns all objects.
	 * 
	 * @return
	 */
	public Iterable<T> findAll();

	/**
	 * Creates a new object.
	 * 
	 * @param objectList
	 * @return
	 * @throws IntegrityViolationException
	 * @throws EntityNotFoundException
	 */
	public Iterable<T> save(T object) throws IntegrityViolationException, EntityNotFoundException;

	/**
	 * Creates new objects.
	 * 
	 * @param objectList
	 * @return
	 * @throws IntegrityViolationException
	 * @throws EntityNotFoundException
	 */
	public Iterable<T> saveAll(Iterable<T> objectList) throws IntegrityViolationException, EntityNotFoundException;

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
