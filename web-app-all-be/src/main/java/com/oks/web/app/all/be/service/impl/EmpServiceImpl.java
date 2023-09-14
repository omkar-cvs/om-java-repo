package com.oks.web.app.all.be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oks.web.app.all.be.dao.EmpDao;
import com.oks.web.app.all.be.mapper.EmpMapper;
import com.oks.web.app.all.be.service.EmpService;
import com.oks.web.app.all.be.vo.EmpVo;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao empDao;
	
	@Override
	public EmpVo saveEmp(EmpVo empVo) {
		return EmpMapper.INSTANCE.convertDOtoVOForEmp(empDao.saveEmp(EmpMapper.INSTANCE.convertVOtoDOForEmp(empVo)));
	}

	@Override
	public EmpVo updateEmp(EmpVo empVo) {
		return EmpMapper.INSTANCE.convertDOtoVOForEmp(empDao.updateEmp(EmpMapper.INSTANCE.convertVOtoDOForEmp(empVo)));
	}

	@Override
	public void deleteEmp(EmpVo empVo) {
		empDao.deleteEmp(empVo.getId());
		
	}

	@Override
	public List<EmpVo> findAllEmp() {
		return EmpMapper.INSTANCE.convertDOtoVOForAllEmp(empDao.findAllEmp());
	}

	@Override
	public EmpVo getEmp(EmpVo empVo) {
		return EmpMapper.INSTANCE.convertDOtoVOForEmp(empDao.getEmp(EmpMapper.INSTANCE.convertVOtoDOForEmp(empVo)));
	}

}
