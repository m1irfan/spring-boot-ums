package com.needbeyond.ums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @RequiredArgsConstructor
public class Employee {  // I had to make the class name "Employee" as the JPA had issues with the "user" name.
	
	@Id @GeneratedValue
	private long id;
	private String name;
	private String password;

}