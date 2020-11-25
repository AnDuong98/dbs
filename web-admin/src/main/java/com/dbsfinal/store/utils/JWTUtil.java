package com.dbsfinal.store.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.dbsfinal.store.entity.AppUserDetails;

@Component
public class JWTUtil {

	public String getJwtTokenFromSecurityContext() {
		return ((AppUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getJwtToken();
	}

}
