package com.oks.web.app.all.be.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.oks.web.app.all.be.dao.EmpDao;
import com.oks.web.app.all.be.service.impl.EmpServiceImpl;
import com.oks.web.app.all.be.vo.EmpVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpServiceImplTest {
	
	@InjectMocks
	EmpServiceImpl empServiceImpl;
	
	@Mock
	EmpDao empDao;
	
	
	
	@BeforeEach
	void setMockOutput() throws Throwable {
		MockitoAnnotations.initMocks(this);
	}

	public void saveEmpTest() {
		
		EmpVo empVoResult=new EmpVo();
		empVoResult=Mockito.mock(EmpVo.class);
		
		
	}
}
