package com.oks.web.app.all.be.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="EMP")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "EMP_SEQ")
	@SequenceGenerator(name = "EMP_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "EMP_SEQ")
	private Long id;
	private String name;
	private String job;
	private int salary;
	
	/*
	private String dept;
	private int age;
	private Date dateOfJoin;
	private String gender;
	*/
}
