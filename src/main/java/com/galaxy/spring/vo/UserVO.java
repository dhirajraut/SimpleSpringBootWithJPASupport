package com.galaxy.spring.vo;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/* Lombok Annotations. */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserVO {

	@ApiParam(hidden = true)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
