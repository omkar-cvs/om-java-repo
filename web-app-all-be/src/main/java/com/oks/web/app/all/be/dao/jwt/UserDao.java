package com.oks.web.app.all.be.dao.jwt;

import java.util.List;

import com.oks.web.app.all.be.entity.jwt.User;

public interface UserDao {
	User save(User user);
	List<User> loadUsers();
	User findByUserName(String userName);
}
