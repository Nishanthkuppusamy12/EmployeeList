package com.springBoot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public  List<EmployeeDto> getAllEmpoyees(){
		
		return employeeSer.getAllEmployees();
	}
	@PostMapping("/insertEmployees")
	@ResponseBody
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto employee) {
           
		   try {
		   if(employee !=null){
			 return employeeSer.addEmployees(employee);
		   }
		   }catch(Exception e) {
			 System.out.println("There is No Employee Object");	
	}
		return new ResponseEntity<Object>("The object would be null ",HttpStatus.BAD_REQUEST);
}
	
	@PutMapping("/updateEmployee/{id}")
	public void  updateEmployees(@PathVariable("id") String id,@RequestBody EmployeeDto employee) {
		
	      employeeSer.updateEmployees(id,employee); 
	}
    @DeleteMapping("/deleteEmployeeId/{id}")
    @ResponseBody
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id ) {
		
    	try {
    	if(id!=null) {
    	return employeeSer.deleteEmployee(id);
    	}
    	}catch(Exception e) {
    	System.out.println("The current id is Not There");
    	}
    	return new ResponseEntity<Object>("The Current Id is Not There ",HttpStatus.BAD_REQUEST);
		 
	}
    @GetMapping("/getEmployeeId/{id}")
    @ResponseBody
    public ResponseEntity<Object> findByid(@PathVariable String id ,@RequestBody EmployeeDto employee) {
            
    	//if(id!=null) {
    		return employeeSer.findByid(id,employee );
    //}else {
   // System.out.println("The Id Is Not Available");
   // }
    	//return new ResponseEntity<Object>("The current Id Is Not Available",HttpStatus.BAD_REQUEST);	
}
}
