package com.dbsfinal.store.service;

import java.util.ArrayList;
import java.util.List;

import com.dbsfinal.store.dto.RoleDTO;
import com.dbsfinal.store.entity.Role;
import com.dbsfinal.store.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<RoleDTO> getAllRoleByUserName(String username) {
		List<Role> roles = roleRepository.findByUsers_UserName(username);
		List<RoleDTO> roleDTOs = new ArrayList<>();
		roles.forEach(p -> {
			RoleDTO roleDTO = modelMapper.map(p, RoleDTO.class);
			roleDTOs.add(roleDTO);
		});
		return roleDTOs;
	}

}
