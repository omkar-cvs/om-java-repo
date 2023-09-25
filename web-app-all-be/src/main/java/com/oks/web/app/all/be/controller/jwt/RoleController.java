package com.oks.web.app.all.be.controller.jwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oks.web.app.all.be.entity.jwt.Role;
import com.oks.web.app.all.be.service.jwt.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@PostMapping("/save")
	public Role saveRole(@RequestBody Role role) {
		System.out.println("-----------------------------------1111111111111111111----------------------");		
		System.out.println("Role : "+role);
		System.out.println("-----------------------------------1111111111111111111----------------------");
		return roleService.save(role);
	}
	
	@PostMapping("/getRoles")
	public List<Role> getAllRoles(){
		return roleService.loadRoles();
	}
}
