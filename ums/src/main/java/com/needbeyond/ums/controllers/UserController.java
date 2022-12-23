package com.needbeyond.ums.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.needbeyond.ums.dao.UserRepository;
import com.needbeyond.ums.entity.Employee;
import com.needbeyond.ums.errors.UserNotFoundException;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping("users")
	public List<Employee> allUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("user")
	public Employee createUser(@RequestBody Employee employee) {
		return userRepository.save(employee);
	}
	
	@GetMapping("/user/{id}")
	public Employee findUser(@PathVariable long id) {
		return userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("user/{id}")
	public Employee updateUser(@RequestBody Employee newEmployee, @PathVariable long id) {
		return userRepository.findById(id)
		.map(
				employee ->{ employee.setName(newEmployee.getName());
							 employee.setPassword(newEmployee.getPassword());
				return userRepository.save(employee);
							
			})
		.orElseGet(()->{
			newEmployee.setId(id);
			return userRepository.save(newEmployee);
		});
	}
	
	@DeleteMapping("user/{id}")
	public void deleteUser(@PathVariable long id) {
		userRepository.deleteById(id);
	}
	
	
	
}
