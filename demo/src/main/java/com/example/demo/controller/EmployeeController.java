/**
 * 
 */
package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;
import com.example.demo.repository.EmployeeRepository;

/**
 * @author amevigbe
 *
 */
@RestController
@RequestMapping("api/v1")
public class EmployeeController {

	/**
	 * 
	 */
	@Autowired 
	private EmployeeRepository employee;
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employee.findAll();
		
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "id") Long id){
		Optional<Employee> employee_tmp = employee.findById(id);
		
		return ResponseEntity.ok().body(employee_tmp);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable(value = "id") Long id){
		employee.deleteById(id);
		Map<String, Boolean> tmp = new HashMap<>();
		tmp.put("delete", Boolean.TRUE);
		return tmp;
		
		
		
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@Validated @RequestBody Employee newemployee) {
		return employee.save(newemployee);
	}
}
