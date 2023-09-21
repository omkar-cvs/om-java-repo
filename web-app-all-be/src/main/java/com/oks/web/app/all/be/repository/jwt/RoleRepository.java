package com.oks.web.app.all.be.repository.jwt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oks.web.app.all.be.entity.jwt.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByRoleName(String roleName);
	List<Role> findByIdIn(List<Long> roleIdList);
}
