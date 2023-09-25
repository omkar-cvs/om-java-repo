package com.oks.web.app.all.be.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.oks.web.app.all.be.service.EmpService;
import com.oks.web.app.all.be.vo.EmpFindRequestVo;
import com.oks.web.app.all.be.vo.EmpRequestVo;
import com.oks.web.app.all.be.vo.EmpResponseVo;
import com.oks.web.app.all.be.vo.EmpVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpControllerTest {

	@InjectMocks
	EmpController empController;

	@Mock
	EmpService empService;

	@BeforeEach
	void setMockOutput() throws Throwable {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEmpTest() {
		List<EmpVo> empVoListResult = new ArrayList<>();
		EmpVo empVo = new EmpVo();
		empVo = Mockito.mock(EmpVo.class);
		empVoListResult.add(empVo);

		EmpResponseVo empResponseVo = new EmpResponseVo();
		empResponseVo.setEmpVo(empVoListResult);

		EmpFindRequestVo empFindRequestVo = new EmpFindRequestVo();
		empFindRequestVo.setId(1l);

		Mockito.when(empService.getEmp(empFindRequestVo.getId())).thenReturn(empVo);

		ResponseEntity<EmpResponseVo> response = empController.getEmp(empFindRequestVo);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(0, (response.getBody().getEmpVo()));
		assertEquals("200", (response.getBody().getStatus()));
		assertEquals("SUCCESS", (response.getBody().getMessage()));
		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	public void getAllEmpTest() {
		List<EmpVo> empVoListResult = new ArrayList<>();
		EmpVo empVo = new EmpVo();
		empVo = Mockito.mock(EmpVo.class);
		empVoListResult.add(empVo);

		Mockito.when(empService.findAllEmp()).thenReturn(empVoListResult);

		ResponseEntity<EmpResponseVo> response = empController.getAllEmp();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(0, (response.getBody().getEmpVo()));
		assertEquals("200", (response.getBody().getStatus()));
		assertEquals("SUCCESS", (response.getBody().getMessage()));
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void saveEmpTest() {
		List<EmpVo> empVoListResult = new ArrayList<>();
		EmpVo empVo = new EmpVo();
		empVo = Mockito.mock(EmpVo.class);
		empVoListResult.add(empVo);

		EmpResponseVo empResponseVo = new EmpResponseVo();
		empResponseVo.setEmpVo(empVoListResult);

		EmpRequestVo empRequestVo = new EmpRequestVo();
		empRequestVo.setEmpVo(empVo);

		Mockito.when(empService.saveEmp(empRequestVo.getEmpVo())).thenReturn(empVo);
		ResponseEntity<EmpResponseVo> response = empController.saveEmp(empRequestVo);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(0, (response.getBody().getEmpVo()));
		assertEquals("200", (response.getBody().getStatus()));
		assertEquals("SUCCESS", (response.getBody().getMessage()));
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void updateEmpTest() {
		List<EmpVo> empVoListResult = new ArrayList<>();
		EmpVo empVo = new EmpVo();
		empVo = Mockito.mock(EmpVo.class);
		empVoListResult.add(empVo);

		EmpResponseVo empResponseVo = new EmpResponseVo();
		empResponseVo.setEmpVo(empVoListResult);

		EmpRequestVo empRequestVo = new EmpRequestVo();
		empRequestVo.setEmpVo(empVo);

		Mockito.when(empService.updateEmp(empRequestVo.getEmpVo())).thenReturn(empVo);
		ResponseEntity<EmpResponseVo> response = empController.updateEmp(empRequestVo);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(0, (response.getBody().getEmpVo()));
		assertEquals("200", (response.getBody().getStatus()));
		assertEquals("SUCCESS", (response.getBody().getMessage()));
		assertEquals(200, response.getStatusCodeValue());
	}

	@Test
	public void deletempTest() {

		EmpVo empVo = new EmpVo();
		empVo = Mockito.mock(EmpVo.class);

		EmpRequestVo empRequestVo = new EmpRequestVo();
		empRequestVo.setEmpVo(empVo);

		// Mockito.when(empService.updateEmp(empRequestVo.getEmpVo())).thenReturn(empVo);
		doNothing().when(empService).deleteEmp(empRequestVo.getEmpVo());
		ResponseEntity<EmpResponseVo> response = empController.deleteEmp(empRequestVo);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotEquals(0, (response.getBody().getEmpVo()));
		assertEquals("200", (response.getBody().getStatus()));
		assertEquals("SUCCESS", (response.getBody().getMessage()));
		assertEquals(200, response.getStatusCodeValue());
	}

}
