package com.dbsfinal.store.security;

import java.util.ArrayList;
import java.util.List;

import com.dbsfinal.store.dto.RoleDTO;
import com.dbsfinal.store.dto.UserDTO;
import com.dbsfinal.store.service.RoleService;
import com.dbsfinal.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@Override
	public UserDetails loadUserByUsername(String username){
		try {
			UserDTO user = userService.findByUserName(username);
			List<RoleDTO> roles = roleService.getAllRoleByUserName(username);
			List<GrantedAuthority> grantList = new ArrayList<>();
			if (!roles.isEmpty()) {
				roles.forEach(o -> {
					GrantedAuthority authority = new SimpleGrantedAuthority(o.getName());
					grantList.add(authority);	
				});
			}
			return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true,
					user.getStatus() == 1, grantList);
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " not found!");
		}
	}

}
