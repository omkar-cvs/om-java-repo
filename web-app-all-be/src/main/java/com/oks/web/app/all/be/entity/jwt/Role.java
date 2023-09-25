package com.oks.web.app.all.be.entity.jwt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oks.web.app.all.be.entity.Emp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ROLE_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ROLE_SEQ")
	@SequenceGenerator(name = "ROLE_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "ROLE_SEQ")
	private Long id;
	@Column(name="ROLE_NAME",unique = true)
	private String roleName;
	@Column(name="ROLE_DESCRIPTION")
	private String roleDescription;
}
