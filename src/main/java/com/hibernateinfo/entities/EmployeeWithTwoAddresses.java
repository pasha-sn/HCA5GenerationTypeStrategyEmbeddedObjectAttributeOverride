package com.hibernateinfo.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.hibernateinfo.model.Address;

/**
 * @author Pasha Remember the golden rule: readable code is often faster code.
 *         Produce readable code first and only change it if it proves to be too
 *         slow.
 */
@Entity
@Table(name = "employee_two_addresses_table")
@DynamicUpdate
public class EmployeeWithTwoAddresses 
{
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeId;

	@Column(name = "employee_name", length = 200, nullable = false)
	private String employeeName;

	@Column(name = "email")
	private String email;

	@Column(name = "date_of_joing")
	private Date doj;	
	
	@Embedded
	@AttributeOverrides(
			value = {
			@AttributeOverride (column = @Column(name = "address1_street_name", length = 50), name = "street"),
			@AttributeOverride(column = @Column(name = "address1_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "address1_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "address1_postal_code"), name = "postalcode")
			}
			)
	private Address address1;

	@Embedded
	@AttributeOverrides(
			value = {
			@AttributeOverride(column = @Column(name = "address2_street_name", length = 60), name = "street"),
			@AttributeOverride(column = @Column(name = "address2_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "address2_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "address2_postal_code"), name = "postalcode") 
			}
			)
	private Address address2;

	@Column(name = "salary")
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

	public Address getAddress1() {
		return address1;
	}

	public void setAddress1(Address address1) {
		this.address1 = address1;
	}

	public Address getAddress2() {
		return address2;
	}

	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}