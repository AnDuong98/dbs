package com.dbsfinal.store.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.dbsfinal.store.dto.validate.annotation.ValidEmail;
import com.dbsfinal.store.dto.validate.annotation.ValidMatchingPassword;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidMatchingPassword
public class UserDTO extends AbstractDTO {
	
	private int userId;
	
	@NotNull
	@NotEmpty
	private String fullName;
	
	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;
	
	@NotNull
	@NotEmpty
	private String userName;
	
	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;
	
	private boolean enabled;
		
}
