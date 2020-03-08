package com.galaxy.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* Lombok Annotations. */
@Getter
@Setter
@NoArgsConstructor
@ToString

/* JPA Annotations. */
@Entity
@Table (name = "user")
public class UserEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (nullable = false, name = "firstname")
	private String firstName;
	
	@Column (nullable = true, name = "lastname")
	private String lastName;
	
	@Column (nullable = false, unique = true)
	private String email;
}
