package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.main.model.Employee;
import com.springboot.main.repository.EmployeeRepository;

@Service
public class EmployeeServiceimp implements EmployeeService {
	private EmployeeRepository EmployeeRepository;
	
	public EmployeeServiceimp(EmployeeRepository EmployeeRepository) {
		this.EmployeeRepository=EmployeeRepository;
	}

	@Override
	public void save(Employee Employee) {
		EmployeeRepository.save(Employee);
		
	}

	@Override
	public List<Employee> findall() {
		List<Employee> st = EmployeeRepository.findAll();
		return st;
	}

	@Override
	public void delete(int id) {
		EmployeeRepository.deleteById(id);
	}

	@Override
	public void update(Employee Employee) {
		EmployeeRepository.save(Employee);	
	}
	@Override
	public Employee findById(int  id) {
	Optional<Employee> user=	EmployeeRepository.findById(id);
	Employee us=null;
	if(user.isPresent()) {
		us= user.get();
	}
		return us;
	}

}
