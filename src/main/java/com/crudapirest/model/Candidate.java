package com.crudapirest.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table(name = "candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 70)
	private String name;
	
	@Column(name = "email", nullable = false, length = 70)
	private String email;
	
	@Column(name = "gender", nullable = false, length = 70)
	private String gender;
	
	@Column(name = "salary_expected", nullable = false, length = 70)
	private String salaryExpected;

}
