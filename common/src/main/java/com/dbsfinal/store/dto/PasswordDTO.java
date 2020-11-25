package com.dbsfinal.store.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.dbsfinal.store.dto.validate.annotation.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {
	
	@NotNull
	@NotEmpty
	@ValidPassword
	private String newPassword;
	private String confirmPassword;
	
}
