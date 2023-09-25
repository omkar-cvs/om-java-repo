package com.oks.web.app.all.be.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oks.web.app.all.be.constants.Constants;
import com.oks.web.app.all.be.service.EmpService;
import com.oks.web.app.all.be.vo.*;

@RestController
@RequestMapping("/emp")
public class EmpController {

	private static final Logger logger = LogManager.getLogger(EmpController.class);
	@Autowired
	EmpService empService;
	
	@Value("${APP.VERSION}")
	private String VERSION;
	
	@Value("${APP.ENV}")
	private String ENV;

	@PostMapping("/save")
	public ResponseEntity<EmpResponseVo> saveEmp(@Valid @RequestBody EmpRequestVo empRequestVo) {
		System.out.println();
		List<EmpVo> empVoList = new ArrayList<>();
		EmpVo empVo = empService.saveEmp(empRequestVo.getEmpVo());
		empVoList.add(empVo);

		return new ResponseEntity<>(
				EmpResponseVo.serviceResponse(Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE, empVoList),
				HttpStatus.OK);
	}
	
	@PostMapping("/find")
	public ResponseEntity<EmpResponseVo> getEmp(@Valid @RequestBody EmpFindRequestVo empFindRequestVo){
		logger.info("Enter in EmpController{}:getEmp() \n"+empFindRequestVo);
		List<EmpVo> empVoList = new ArrayList<>();
		EmpVo empVo = empService.getEmp(empFindRequestVo.getId());
		if(empVo!=null)
			empVoList.add(empVo);
		logger.info("Exit from EmpController{}:getEmp() ");
		return new ResponseEntity<>(
				EmpResponseVo.serviceResponse((empVoList.isEmpty()? "There is no such record found":Constants.SUCCESS_MESSAGE), Constants.SUCCESS_CODE, empVoList),
				HttpStatus.OK);
	}
	
	@PostMapping("/findAll")
	public ResponseEntity<EmpResponseVo> getAllEmp(){
		System.out.println();
		List<EmpVo> empVoList = empService.findAllEmp();
		
		return new ResponseEntity<>(
				EmpResponseVo.serviceResponse((empVoList.isEmpty()? "There is no such record found":Constants.SUCCESS_MESSAGE), Constants.SUCCESS_CODE, empVoList),
				HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<EmpResponseVo> deleteEmp(@Valid @RequestBody EmpRequestVo empRequestVo){
		System.out.println();
		List<EmpVo> empVoList = new ArrayList<>();
		empService.deleteEmp(empRequestVo.getEmpVo());
		EmpVo empVo=null;
		String SUCCESS_MESSAGE="Record deleted successfully";
		if(empVo==null)
			empVoList.add(empVo);

		return new ResponseEntity<>(
				EmpResponseVo.serviceResponse((empVoList.isEmpty()? "There is no such record found":Constants.SUCCESS_MESSAGE), Constants.SUCCESS_CODE, empVoList),
				HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<EmpResponseVo> updateEmp(@Valid @RequestBody EmpRequestVo empRequestVo) {
		System.out.println();
		List<EmpVo> empVoList = new ArrayList<>();
		EmpVo empVo = empService.updateEmp(empRequestVo.getEmpVo());
		empVoList.add(empVo);

		return new ResponseEntity<>(
				EmpResponseVo.serviceResponse(Constants.SUCCESS_MESSAGE, Constants.SUCCESS_CODE, empVoList),
				HttpStatus.OK);
	}
	
	@GetMapping("/env")
	public String getEnvironmentAndVersion(){
		return ENV+"    "+VERSION;
	}
	
}
