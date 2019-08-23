package com.hibernateinfo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.hibernateinfo.model.Address;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
@Entity
@Table(name="employee_table")
//Update the given value not all fields.  
//example: update employee_table set salary = ? where employee_id=?
//https://stackoverflow.com/questions/41633250/how-dynamic-update-true-works-internally-in-hibernate
//https://www.mkyong.com/hibernate/hibernate-dynamic-update-attribute-example/
@DynamicUpdate   
public class Employee 
{
	@Id
	//https://stackoverflow.com/questions/14022374/the-differences-between-generatedvalue-strategies
	//We should prefer to use the SEQUENCE Strategy. it is efficient and allows Hibernate 
	//to decide when to inform insert statement.
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="generator")
	@SequenceGenerator(name = "generator", initialValue=18, allocationSize=3, sequenceName="ID_SEQ_INIT_18_INCR_3" )
	@Column(name="ID_SEQ_INIT_18_INCR_3")
	private Integer employeeId;
	
	@Column(name="employee_name",length=100, nullable=false )
	private String employeeName;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="date_of_join")
	private Date doj;
	
	//https://stackoverflow.com/questions/35174981/when-to-use-embedded-and-embeddable
	//https://stackoverflow.com/questions/7664523/what-impact-does-the-embedded-annotation-mean
	//embedded field, existence of object is dependent to Employee
	@Embedded
	private Address address;
	
	@Column(name="salary")
	private Double salary;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", doj="
				+ doj + ", salary=" + salary + "]";
	}	
}