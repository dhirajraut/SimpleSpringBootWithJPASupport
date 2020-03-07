package com.galaxy.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Lombok Annotations. */
@Getter
@Setter
@NoArgsConstructor

/* JPA Annotations. */
@Entity
public class UserEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column (nullable = false)
	private String firstName;
	
	@Column (nullable = true)
	private String lastName;
	
	@Column (nullable = false)
	private String email;
}
