package com.springboot.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.Exception.EmployeeException;
import com.springboot.main.Exception.exceptionModel;
import com.springboot.main.model.Employee;
import com.springboot.main.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class controllar {
	
	private EmployeeService EmployeeService;
	
	
	public controllar(EmployeeService EmployeeService) {
		this.EmployeeService=EmployeeService;
	}
		
	
	
	@GetMapping("/Employee")
	public List<Employee> Selecte_All_Employee() {
		List<Employee> emp=EmployeeService.findall();
	
		return emp;
	}
	
	
	@GetMapping("/Employee/{id}")
	public Employee Selecte_Employee(@PathVariable int id) throws EmployeeException {
		Employee emp=null;
			emp=EmployeeService.findById(id);
			if(emp == null) {
				throw new EmployeeException("employee not found "+ id);	
			}
		return emp;
		
	}
	@DeleteMapping("/Employee/{id}")
	public String Delete_Employee(@PathVariable int id) {
		
		EmployeeService.delete(id);
		return "done";
		
	}
	@PostMapping("/Employee")
	public String Create_Employee(@RequestBody Employee Employee) {
		EmployeeService.save(Employee);
			return "create the done";
		
	}
	@PutMapping("/Employee")
	public String Update_Employee(@RequestBody Employee Employee) {
		EmployeeService.save(Employee);
			return "update the done";
		
	}
	@ExceptionHandler
	public ResponseEntity<exceptionModel> handelexception(EmployeeException ex) {
		exceptionModel  error= new  exceptionModel();
		error.setMassage(ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		ResponseEntity<exceptionModel> response= new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		return response;
	}
}
