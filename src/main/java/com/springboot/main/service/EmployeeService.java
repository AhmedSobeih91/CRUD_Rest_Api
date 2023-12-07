package com.springboot.main.service;

import java.util.List;

import com.springboot.main.model.Employee;

public interface EmployeeService {
	void save(Employee Employee);
	List<Employee> findall();
	void delete(int id);
	void update(Employee Employee);
	Employee findById(int  id);

}
