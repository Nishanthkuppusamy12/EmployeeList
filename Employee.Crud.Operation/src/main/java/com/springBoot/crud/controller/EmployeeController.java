package com.springBoot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.crud.bean.EmployeeDto;
import com.springBoot.crud.service.EmployeeService;

@RestController
public class EmployeeController{
	@Autowired
	private EmployeeService employeeSer;
	
	@RequestMapping("/employees")
	public List<EmployeeDto> getAllEmpoyees(){
		
		return employeeSer.getAllEmployees();
	}
	@PostMapping("/employees")
	public void addEmployees(@RequestBody EmployeeDto employee) {
		
		employeeSer.addEmployees(employee);	
	}
	
	@PutMapping("/employee/{id}")
	public void updateEmployees(@PathVariable String id,@RequestBody EmployeeDto employee) {
		
		employeeSer.updateEmployees(id,employee);
	}
    @DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable String id ) {
		
    	employeeSer.deleteEmployee(id);
	}
}
