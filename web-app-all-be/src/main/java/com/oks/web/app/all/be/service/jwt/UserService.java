package com.oks.web.app.all.be.service.jwt;

import java.util.List;

import com.oks.web.app.all.be.entity.jwt.User;

public interface UserService {
	User save(User user);

	List<User> loadUsers();

	User registerNewUser(User user);
	
	public void initRoleAndUser();
}
