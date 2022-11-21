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

	public void addEmployees(EmployeeDto employee) {
       
		//if(employee!=null) {
		//return new ResponseEntity<>("Employee is Empty ",HttpStatus.BAD_REQUEST);
		//}else {
		 employeeRepo.save(employee);
		//return new ResponseEntity<>("Employee added succefully \n status code is 200 ",HttpStatus.OK);
		//}
	}
	public ResponseEntity<Object> updateEmployees(String id,EmployeeDto employee) {
	
	     employeeRepo.save(employee);
		 return new ResponseEntity<>("Employee Updated Succefully",HttpStatus.OK);
	}
	public ResponseEntity<Object> deleteEmployee(String id) {
		 
		if(!(id.isEmpty())) {
		 employeeRepo.deleteById(id);
		 return new ResponseEntity<>("deleted succefully ",HttpStatus.OK);
		}return new ResponseEntity<>("There is No current id ",HttpStatus.BAD_REQUEST);
	
	}

	public ResponseEntity<?> findById(String id) {
		
		   employeeRepo.findById(id);
	//return null;
	return null;
	   
	}

}
