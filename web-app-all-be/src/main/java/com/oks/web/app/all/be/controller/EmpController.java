package com.oks.web.app.all.be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.oks.web.app.all.be.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;
}
