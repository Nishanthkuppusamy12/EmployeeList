package com.springBoot.crud.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;

import com.springBoot.crud.bean.EmployeeDto;
import com.springBoot.crud.repository.EmployeeRepository;

@Service
@SpringBootApplication
public class EmployeeService {
	@Autowired
	public EmployeeRepository employeeRepo;
	
	public List<EmployeeDto> getAllEmployees(){
		
		List<EmployeeDto> employee = new ArrayList<>();
		employeeRepo.findAll().forEach(employee::add);
		return employee;
	}

	public ResponseEntity<Object> addEmployees(EmployeeDto employee) {
       
	 employeeRepo.save(employee);
	return new ResponseEntity<Object>("Employee Added Succefully ",HttpStatus.OK);

	}
	public ResponseEntity<Object> deleteEmployee(String id) {
		 
		employeeRepo.deleteById(id);
		return new ResponseEntity<Object>("Deleted succefully ",HttpStatus.OK);
	}

	public ResponseEntity<Object> getEmployeeByid(String id,EmployeeDto employee) {
		
		employeeRepo.save(employee);
	    return new ResponseEntity<Object>("The Given Id is Here",HttpStatus.OK);
	   
	}

	public ResponseEntity<Object> updateEmployees(String id, EmployeeDto employee) {
		     
		 employeeRepo.save(employee);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}


}
