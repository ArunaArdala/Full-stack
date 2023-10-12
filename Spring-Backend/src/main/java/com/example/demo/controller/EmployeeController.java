package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api1/v1/")
public class EmployeeController {

	@Autowired
	EmployeeInterface employeeRepository;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	@PostMapping("employees")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id)
	{
		return ResponseEntity.ok(employeeRepository.findById(id).get());
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("NO Employee found for give Id"+id));
		
		
		employee.setEmailId(employeeDetails.getEmailId());;
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setSecondName(employeeDetails.getSecondName());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id)
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("NO Employee found for give Id"+id));
		
		 employeeRepository.delete(employee);
		 Map<String,Boolean> response = new HashMap<>();
		 response.put("deleted", Boolean.TRUE);
		 return ResponseEntity.ok(response);
	}
}
