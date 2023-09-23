package com.oks.web.app.all.be.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.oks.web.app.all.be.constants.Constants;
import com.oks.web.app.all.be.dao.EmpDao;
import com.oks.web.app.all.be.exception.WebAppServiceAllBeException;
import com.oks.web.app.all.be.mapper.EmpMapper;
import com.oks.web.app.all.be.service.EmpService;
import com.oks.web.app.all.be.vo.EmpVo;
//https://springframework.guru/using-ehcache-3-in-spring-boot/
@Service
@CacheConfig(cacheNames = "empVoCache")
public class EmpServiceImpl implements EmpService {

	private static final Logger logger = LogManager.getLogger(EmpServiceImpl.class);
	@Autowired
	EmpDao empDao;

	@Override
	public EmpVo saveEmp(EmpVo empVo) {
		logger.info("Enter in EmpServiceImp{}:saveEmp()");
		try {
			empVo = EmpMapper.INSTANCE
					.convertDOtoVOForEmp(empDao.saveEmp(EmpMapper.INSTANCE.convertVOtoDOForEmp(empVo)));
		} catch (RuntimeException ex) {
			logger.error("Emp Data not saved : " + ex);
			throw new WebAppServiceAllBeException(Constants.INTERNAL_SERVER_ERROR_SAVE);
		}		
		logger.info("Exit from EmpServiceImp{}:saveEmp()");
		return empVo;
	}

	@Override
	@Cacheable(key="#id")
	public EmpVo getEmp(Long id) {
		logger.info("Enter in EmpServiceImp{}:getEmp() ");
		EmpVo empVo=null;
		try {
			empVo = EmpMapper.INSTANCE
					.convertDOtoVOForEmp(empDao.getEmp(id));
		} catch (RuntimeException ex) {
			logger.error("Emp Data not Found : " + ex);
			throw new WebAppServiceAllBeException(Constants.INTERNAL_SERVER_ERROR_FIND);
		}
		logger.info("Exit from EmpServiceImp{}:getEmp() ");
		return empVo;
	}

	@Override
	public List<EmpVo> findAllEmp() {
		logger.info("Enter in EmpServiceImp{}:findAllEmp() ");
		List<EmpVo> empVoList = null;
		try {
			empVoList = EmpMapper.INSTANCE.convertDOtoVOForAllEmp(empDao.findAllEmp());
		} catch (RuntimeException ex) {
			logger.error("Emp Data not saved : " + ex);
			throw new WebAppServiceAllBeException(Constants.INTERNAL_SERVER_ERROR_FIND_ALL);
		}
		logger.info("Exit from EmpServiceImp{}:findAllEmp() ");
		return empVoList;
	}

	@Override
	@CacheEvict(key="#empVo.id")
	public void deleteEmp(EmpVo empVo) {
		logger.info("Enter in EmpServiceImp{}:deleteEmp() ");
		try {
			empDao.deleteEmp(empVo.getId());
		} catch (RuntimeException ex) {
			logger.error("Emp Data not Deleted : " + ex);
			throw new WebAppServiceAllBeException(Constants.INTERNAL_SERVER_ERROR_DELETE);
		}
		logger.info("Exit from EmpServiceImp{}:deleteEmp() ");
	}

	@Override
	@CachePut(key="#empVo.id")
	public EmpVo updateEmp(EmpVo empVo) {
		logger.info("Enter in EmpServiceImp{}:updateEmp() ");
		try {
			empVo = EmpMapper.INSTANCE
					.convertDOtoVOForEmp(empDao.updateEmp(EmpMapper.INSTANCE.convertVOtoDOForEmp(empVo)));
		} catch (RuntimeException ex) {
			logger.error("Emp Data not updated : " + ex);
			throw new WebAppServiceAllBeException(Constants.INTERNAL_SERVER_ERROR_UPDATE);
		}
		logger.info("Exit from EmpServiceImp{}:updateEmp() ");
		return empVo;
	}
}
