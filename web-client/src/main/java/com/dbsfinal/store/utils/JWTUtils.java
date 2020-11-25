package com.dbsfinal.store.utils;

import com.dbsfinal.store.entity.AppUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JWTUtils {

	public String getJwtTokenFromSecurityContext() {
		return ((AppUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getJwtToken();
	}

}
