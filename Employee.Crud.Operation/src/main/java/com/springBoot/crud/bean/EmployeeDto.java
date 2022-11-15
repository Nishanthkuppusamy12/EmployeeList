package com.springBoot.crud.bean;


import org.springframework.context.annotation.ComponentScan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="employee")
public class EmployeeDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
    private int age;
	private int experience;

	public EmployeeDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public EmployeeDto(int id, String name, int age, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.experience =experience;
	}

	@Override
	public String toString() {
		return "EmployeeDao [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience + "]";
	}

}
