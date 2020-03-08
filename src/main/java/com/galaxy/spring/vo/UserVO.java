package com.galaxy.spring.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Lombok Annotations. */
@Getter
@Setter
@NoArgsConstructor
public class UserVO {

	@ApiParam(hidden = true)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
