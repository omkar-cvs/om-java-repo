package com.oks.web.app.all.be.service.jwt.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.oks.web.app.all.be.dao.jwt.RoleDao;
import com.oks.web.app.all.be.dao.jwt.UserDao;
import com.oks.web.app.all.be.entity.jwt.Role;
import com.oks.web.app.all.be.entity.jwt.User;
import com.oks.web.app.all.be.service.jwt.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {
		
		/* This is used for resolving detached entity exception during user creation */
		Set<Role> roles=user.getRole();
		List<Long> roleIdList=roles.stream().map(r->r.getId()).collect(Collectors.toList());
		
		/*Getting the save role from database */
		List<Role> list=roleDao.findByIdIn(roleIdList);
		
		/* Converting list to set for setting in user Roles */
		roles=list.stream().collect(Collectors.toSet());
		
		/* Finally settled roles for save role with user*/
		user.setRole(roles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));//gerEncodedPassword(user.getPassword());
		
		return userDao.save(user);
	}

	@Override
	public List<User> loadUsers() {
		return userDao.loadUsers();
	}

	@Override
	public User registerNewUser(User user) {
		Role role=roleDao.findByRoleName("USER");
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(role);
		user.setRole(userRoles);
		user.setUserPassword(getEncodedPassword(user.getUserPassword()));//getEncodedPassword(user.getPassword());
		
		return userDao.save(user);
	}
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
	
	
	//for defult saving the data [for save uncomment in controller
	public void initRoleAndUser() {

        Role adminRole = new Role();      
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();   
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

}
