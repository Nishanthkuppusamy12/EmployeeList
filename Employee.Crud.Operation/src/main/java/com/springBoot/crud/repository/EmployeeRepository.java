package com.springBoot.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.crud.bean.EmployeeDto;

public interface EmployeeRepository extends CrudRepository<EmployeeDto,String>{

	
}
