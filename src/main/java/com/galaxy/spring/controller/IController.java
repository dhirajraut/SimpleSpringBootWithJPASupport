package com.galaxy.spring.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RestController;

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
	 * Creates new objects.
	 * 
	 * @param objectList
	 * @return
	 * @throws DataIntegrityViolationException
	 * @throws EntityNotFoundException
	 */
	public Iterable<T> saveAll(Iterable<T> objectList) throws DataIntegrityViolationException, EntityNotFoundException;

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
