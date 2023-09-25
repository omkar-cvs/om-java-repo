package com.oks.web.app.all.be.dao.jwt.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.web.app.all.be.dao.jwt.UserDao;
import com.oks.web.app.all.be.entity.jwt.User;
import com.oks.web.app.all.be.repository.jwt.UserRepository;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> loadUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
