package com.oks.web.app.all.be.vo;

import com.oks.web.app.all.be.entity.Emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EmpVo {
	private Long id;
	private String name;
	private String job;
	private int salary;
}
