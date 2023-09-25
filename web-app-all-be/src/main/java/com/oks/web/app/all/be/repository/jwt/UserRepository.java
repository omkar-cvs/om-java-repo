package com.oks.web.app.all.be.repository.jwt;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oks.web.app.all.be.entity.jwt.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);
}
