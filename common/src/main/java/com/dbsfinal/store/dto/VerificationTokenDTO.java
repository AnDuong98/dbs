package com.dbsfinal.store.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationTokenDTO {
	
	private Long id;
	private String token;
	private UserDTO user;
	private Date expiryDate;
	
}
