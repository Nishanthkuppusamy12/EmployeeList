package com.springBoot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.crud.bean.EmployeeDto;
import com.springBoot.crud.service.EmployeeService;


@RestController
@RequestMapping(value="/")
public class EmployeeController{
	@Autowired
	private EmployeeService employeeSer;
	
	@GetMapping("/getAllEmployees")
	public @ResponseBody List<EmployeeDto> getAllEmpoyees(){
		
		return employeeSer.getAllEmployees();
	}
	@PostMapping("/insertEmployees")
	public ResponseEntity<Object
	> addEmployee(@RequestBody EmployeeDto employee) {
		
		 return employeeSer.addEmployees(employee);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployees(@PathVariable String id,@RequestBody EmployeeDto employee) {
		
		if(id!=null) {
	    return employeeSer.updateEmployees(id,employee);
		}else return new ResponseEntity<>("there is no current id",HttpStatus.BAD_REQUEST);
	
	  
	}
    @DeleteMapping("/deleteEmployeeId/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id ) {
		
    	return employeeSer.deleteEmployee(id);
    	
	}
    @GetMapping("/getEmployeeId/{id}")
    public @ResponseBody ResponseEntity<Object> findById(@PathVariable String id ,@RequestBody EmployeeDto employee) {
    
           return employeeSer.findById(id);
    }
}
