package com.dbsfinal.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbsfinal.store.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	List<Role> findByUsers_UserName(String username);

	Role findByName(String string);
	
}
