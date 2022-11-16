package com.springBoot.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

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

	public  ResponseEntity<Object> addEmployees(EmployeeDto employee) {
		
		
		employeeRepo.save(employee);
		return new ResponseEntity<>("Employee added succefully \n status code is 200 ",HttpStatus.OK);
	}
	public ResponseEntity<Object> updateEmployees(String id,EmployeeDto employee) {
	
	     employeeRepo.save(employee);
		  return new ResponseEntity<>("Employee Updated Succefully",HttpStatus.OK);
	}
	public ResponseEntity<Object> deleteEmployee(String id) {
		
		 employeeRepo.deleteById(id);
		 return new ResponseEntity<>("deleted succefully ",HttpStatus.OK);
	
	}

	public ResponseEntity<Object> findById(String id) {
		
	   employeeRepo.findById(id);
	return null;
	   
	}

}
