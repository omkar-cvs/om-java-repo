package com.oks.web.app.all.be.dao;

import java.util.List;
import com.oks.web.app.all.be.entity.Emp;

public interface EmpDao {
	Emp saveEmp(Emp emp);

	Emp updateEmp(Emp emp);

	void deleteEmp(Long id);

	List<Emp> findAllEmp();

	Emp getEmp(Long id);

}
