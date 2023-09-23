package com.oks.web.app.all.be.service;

import java.util.List;

import com.oks.web.app.all.be.vo.EmpVo;

public interface EmpService {
	EmpVo saveEmp(EmpVo empVo);

	EmpVo updateEmp(EmpVo empVo);

	void deleteEmp(EmpVo empVo);

	List<EmpVo> findAllEmp();

	EmpVo getEmp(Long id);

}
