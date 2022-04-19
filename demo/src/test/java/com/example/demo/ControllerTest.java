/**
 * 
 */
package com.example.demo;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;

/**
 * @author amevigbe
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:8080/api/v1";
	}
	@Test 
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setEmail("admin@gmail.com");
		employee.setFirstname("admin");
		employee.setLastName("admin");

		
		ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/employee", employee, Employee.class);
		System.out.println(postResponse);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}


}
