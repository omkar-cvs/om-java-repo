package com.oks.web.app.all.be.service.jwt.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.web.app.all.be.dao.jwt.RoleDao;
import com.oks.web.app.all.be.entity.jwt.Role;
import com.oks.web.app.all.be.service.jwt.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role save(Role role) {
		return roleDao.save(role);
	}

	@Override
	public List<Role> loadRoles() {
		return roleDao.loadRoles();
	}
	
}
