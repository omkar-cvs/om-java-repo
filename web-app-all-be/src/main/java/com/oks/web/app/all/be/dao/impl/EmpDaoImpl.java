package com.oks.web.app.all.be.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oks.web.app.all.be.dao.EmpDao;
import com.oks.web.app.all.be.entity.Emp;
import com.oks.web.app.all.be.repository.EmpRepository;

@Component
public class EmpDaoImpl implements EmpDao {

	@Autowired
	EmpRepository empRepository;

	@Override
	public Emp saveEmp(Emp emp) {
		return empRepository.save(emp);
	}

	@Override
	public Emp updateEmp(Emp emp) {
		Emp e = getEmp(emp.getId());
		if (e != null) {
			saveEmp(emp);
		} else {
			emp.setName("update failed");
		}
		return emp;
	}

	@Override
	public void deleteEmp(Long id) {
		empRepository.deleteById(id);
	}

	@Override
	public List<Emp> findAllEmp() {
		return empRepository.findAll();
	}

	@Override
	public Emp getEmp(Long id) {
		Optional<Emp> empOp = empRepository.findById(id);
		if (empOp.isPresent()) {
			return empOp.get();
		}
		return null;
	}

}
