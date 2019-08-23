package com.hibernateinfo.client;

import java.util.Date;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.model.Address;
import com.hibernateinfo.service.EmployeeService;
import com.hibernateinfo.service.impl.EmployeeServiceImpl;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest1CreateEmployeeSEQUENCEStrategySingleAddress {

	public static void main(String[] args) 
	{

		EmployeeService employeeService = new EmployeeServiceImpl();
		createEmployee(employeeService);		
		
	}	
	
	private static void createEmployee(EmployeeService employeeService) {
		employeeService.createEmployee(getEmployee());
	}
	
	//One rule-of-thumb: ask yourself "does it make sense to call this method, 
	//even if no Obj has been constructed yet?" If so, it should definitely be static.
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Pasha Sadi");
		employee.setEmail("pasha.sn@gmail.com");
		employee.setSalary(65000.00);
		employee.setDoj(new Date());
		
		Address address = new Address();
		address.setStreet("Peel");
		address.setCity("Montreal");
		address.setState("Quebec");
		address.setPostalcode(19317l);
		employee.setAddress(address);
		return employee;
	}	
}
/*
<property name="hibernate.hbm2ddl.auto">create</property>
Hibernate: 
    
    drop table employee_table cascade constraints
Hibernate: 
    
    drop sequence ID_SEQ_INIT_18_INCR_3
Hibernate: create sequence ID_SEQ_INIT_18_INCR_3 start with 18 increment by  3
 
    
    create table employee_table (
       ID_SEQ_INIT_18_INCR_3 number(10,0) not null,
        city_name varchar2(50 char),
        postal_code number(19,0),
        state_name varchar2(255 char),
        street_name varchar2(50 char),
        date_of_join timestamp,
        email varchar2(255 char),
        employee_name varchar2(100 char) not null,
        salary double precision,
        primary key (ID_SEQ_INIT_18_INCR_3)
    )
Hibernate: 
    
    alter table employee_table 
       add constraint UK_2caspbavi9s2312f9mhm unique (email)
Hibernate: 
    select
        ID_SEQ_INIT_18_INCR_3.nextval 
    from
        dual
Hibernate: 
    select
        ID_SEQ_INIT_18_INCR_3.nextval 
    from
        dual
Employee is created with Id:: 18
Hibernate: 
    insert 
    into
        employee_table
        (city_name, postal_code, state_name, street_name, date_of_join, email, employee_name, salary, ID_SEQ_INIT_18_INCR_3) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?)
*/	