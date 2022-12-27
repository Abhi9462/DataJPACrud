package com.springboot.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="emp1")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eid")
	private Integer empID;
	@Column(name="ename")
	private String empName;
	public Employee(String empName, String empEmail, String empAddress, long empPhone) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empPhone = empPhone;
	}
	@Column(name="eemail")
	private String empEmail;
	@Column(name="eaddress")
	private String empAddress;
	@Column(name="ephone")
	private long empPhone;

	
}
