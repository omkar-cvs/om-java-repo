package com.oks.web.app.all.be.dao.jwt.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.web.app.all.be.dao.jwt.RoleDao;
import com.oks.web.app.all.be.entity.jwt.Role;
import com.oks.web.app.all.be.repository.jwt.RoleRepository;

@Component
public class RoleDaoImpl implements RoleDao {
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> loadRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public List<Role> findByIdIn(List<Long> roleIdList) {
		return roleRepository.findByIdIn(roleIdList);
	}

}
