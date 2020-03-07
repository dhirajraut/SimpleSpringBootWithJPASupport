package com.galaxy.spring.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Lombok Annotations. */
@Getter
@Setter
@NoArgsConstructor
public class UserVO {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
