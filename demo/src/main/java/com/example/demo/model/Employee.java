/**
 * 
 */
package com.example.demo.model;
import javax.persistence.*;


/**
 * @author amevigbe
 *
 */


@Entity
@Table(name = "employees")
public class Employee {

	/**
	 * 
	 */
	private long id ;
	private String firstname;
	private String lastName;
	private String email;
	public Employee() {
		
	}
	public Employee(String lastName, String firstName, String email) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.lastName = lastName;
		this.firstname = firstName;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "first_name", nullable=false)
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	@Column(name = "last_name", nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "email", nullable=false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[Employee " + this.firstname + " ]";
	}
	

}
