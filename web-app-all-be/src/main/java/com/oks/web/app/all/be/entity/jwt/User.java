package com.oks.web.app.all.be.entity.jwt;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQ")
	@SequenceGenerator(name = "USER_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "USER_SEQ")
	private Long Id;
	
	@Column(name="USER_NAME",unique = true)
	private String userName;
	@Column(name="USER_FIRST_NAME")
	private String userFirstName;
	@Column(name="USER_LAST_NAME")
	private String userLastName;
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "USER_ROLE",
	            joinColumns = {
	                    @JoinColumn(name = "USER_ID")
	            },
	            inverseJoinColumns = {
	                    @JoinColumn(name = "ROLE_ID")
	            }
	    )
	    private Set<Role> role;

}
