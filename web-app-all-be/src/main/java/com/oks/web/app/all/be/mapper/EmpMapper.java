package com.oks.web.app.all.be.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.oks.web.app.all.be.entity.Emp;
import com.oks.web.app.all.be.vo.EmpVo;

@Mapper
public interface EmpMapper {

	EmpMapper INSTANCE = Mappers.getMapper(EmpMapper.class);

	Emp convertVOtoDOForEmp(EmpVo empVo);

	EmpVo convertDOtoVOForEmp(Emp emp);
	
	List<EmpVo> convertDOtoVOForAllEmp(List<Emp> empList);

}
