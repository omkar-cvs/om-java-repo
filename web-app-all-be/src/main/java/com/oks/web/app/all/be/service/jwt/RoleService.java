package com.oks.web.app.all.be.service.jwt;

import java.util.List;

import com.oks.web.app.all.be.entity.jwt.Role;

public interface RoleService {
	Role save(Role role);

	List<Role> loadRoles();
}
