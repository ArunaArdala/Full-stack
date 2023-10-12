package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeInterface;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeInterface employeeRepository;
	
	List<Employee> employeeList = new ArrayList<>();
	Employee employee;
	
	@BeforeEach
	void setUp()
	{
		 employee = new Employee("Aruna","Ardala","email@gmail.com");
		employeeList.add(employee);
	}
	
	@Test
	void testGetAllEmployee()
	{
		when(employeeRepository.findAll()).thenReturn(employeeList);
		assertEquals("Aruna", employeeController.getAllEmployee().get(0).getFirstName());
	}
	
	@Test
	void testSavaEMployee()
	{
//		doNothing().when(employeeRepository).save(employee);
//		employeeController.saveEmployee(employee);
		when(employeeRepository.save(employee)).thenReturn(employee);
		employeeController.saveEmployee(employee);
		Mockito.verify(employeeRepository,times(1)).save(employee);
	}
	
	@Test
	void testGetEmployee()
	{
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
		assertEquals(employee, employeeController.getEmployee(anyLong()).getBody());
		
	}
	
	@Test
	void testUpdateEmployee()
	{
		Employee employee1 = new Employee("Vyshnavi","Ardala","vysh@gmail.com");
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee1));
		when(employeeRepository.save(employee1)).thenReturn(employee1);
		assertEquals("Vyshnavi", employeeController.updateEmployee(anyLong(), employee1).getBody().getFirstName());
		
	}
	
	@Test
	void testUpdateEmployeeWhenExceptionThrown()
	{
		doThrow(ResourceNotFoundException.class).when(employeeRepository).findById(anyLong());
		assertThrows(ResourceNotFoundException.class, ()->employeeController.updateEmployee(anyLong(), employee));
	}
	
	@Test
	void testDeleteEmployee()
	{
		when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
		doNothing().when(employeeRepository).delete(employee);
		assertTrue(employeeController.deleteEmployee(anyLong()).getBody().get("deleted"));
	}
	
	@Test
	void testDeleteEmployeeWhenExceptionThrow()
	{
		doThrow(ResourceNotFoundException.class).when(employeeRepository).findById(anyLong());
		assertThrows(ResourceNotFoundException.class, ()->employeeController.deleteEmployee(anyLong()));

	}
}
