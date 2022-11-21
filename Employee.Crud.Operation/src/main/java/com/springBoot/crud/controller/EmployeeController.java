package com.springBoot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.crud.bean.EmployeeDto;
import com.springBoot.crud.service.EmployeeService;


@RestController
@RequestMapping(value="/")
public class EmployeeController{
	@Autowired
	private EmployeeService employeeSer;
	
	@GetMapping("/getAllEmployees")
	public  List<EmployeeDto> getAllEmpoyees(){
		
		return employeeSer.getAllEmployees();
	}
	@PostMapping("/insertEmployees")
	public void addEmployee(@RequestBody EmployeeDto employee) {
		
	     employeeSer.addEmployees(employee);
	
	}
	
	@PatchMapping("/updateEmployee/{id}")
	public ResponseEntity<Object> updateEmployees(@PathVariable String id,@RequestBody EmployeeDto employee) {
		
		//if(!(id.isEmpty())) {
	     return employeeSer.updateEmployees(id,employee); 
		//}else return new ResponseEntity<>("employee is empty ",HttpStatus.BAD_REQUEST);
	}
    @DeleteMapping("/deleteEmployeeId/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id ) {
		//if(!(id.isEmpty())) {
    	 return employeeSer.deleteEmployee(id);
		//}else return new ResponseEntity<>("Employee Id is empty ",HttpStatus.BAD_REQUEST);

	}
    @GetMapping("/getEmployeeId/{id}")
    public ResponseEntity<?> findById(@PathVariable String id ,@RequestBody EmployeeDto employee) {
    
            return employeeSer.findById(id);
    }
}
