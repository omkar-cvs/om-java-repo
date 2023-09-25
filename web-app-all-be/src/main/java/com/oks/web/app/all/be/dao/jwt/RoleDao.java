package com.oks.web.app.all.be.dao.jwt;

import java.util.List;

import com.oks.web.app.all.be.entity.jwt.Role;

public interface RoleDao {
	Role save(Role role);
	List<Role> loadRoles();
	Role findByRoleName(String  roleName);
	List<Role> findByIdIn(List<Long> roleIdList);
}
