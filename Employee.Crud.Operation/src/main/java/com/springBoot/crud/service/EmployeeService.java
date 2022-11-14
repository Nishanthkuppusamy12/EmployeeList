package com.springBoot.crud.service;

import java.util.ArrayList;
import java.util.List;

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
		
		employeeRepo.save(employee);
	}

	public void updateEmployees(String id,EmployeeDto employee) {
		
		employeeRepo.save(employee);
	}

	public void deleteEmployee(String id) {
		
		employeeRepo.deleteById(id);
	}

}
