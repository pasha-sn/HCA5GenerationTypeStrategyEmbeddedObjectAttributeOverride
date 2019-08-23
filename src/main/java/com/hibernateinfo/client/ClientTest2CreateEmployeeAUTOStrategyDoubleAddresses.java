package com.hibernateinfo.client;

import java.util.Date;

import org.hibernate.Session;

import com.hibernateinfo.entities.EmployeeWithTwoAddresses;
import com.hibernateinfo.model.Address;
import com.hibernateinfo.util.HibernateUtil;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest2CreateEmployeeAUTOStrategyDoubleAddresses {

	public static void main(String[] args) 
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			createEmployeeTwoAddresses(session);		

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}	
	
	private static void createEmployeeTwoAddresses(Session session) {
		session.beginTransaction();
		session.save(getEmployee());
		session.getTransaction().commit();
	}
	
	//One rule-of-thumb: ask yourself "does it make sense to call this method, 
	//even if no Obj has been constructed yet?" If so, it should definitely be static.
	private static EmployeeWithTwoAddresses getEmployee(){
		EmployeeWithTwoAddresses employee= new EmployeeWithTwoAddresses();
		employee.setEmployeeName("Pasha Sadi");
		employee.setEmail("pasha.sn@gmail.com");
		employee.setSalary(65000.00);
		employee.setDoj(new Date());
		
		Address address1 = new Address();
		address1.setStreet("Peel");
		address1.setCity("Montreal");
		address1.setState("Quebec");
		address1.setPostalcode(19317l);
		
		
		Address address2 = new Address();
		address2.setStreet("Peel2");
		address2.setCity("Montreal2");
		address2.setState("Quebec2");
		address2.setPostalcode(19318l);
		
		employee.setAddress1(address1);
		employee.setAddress2(address2);
		return employee;
	}	
}
/*
<property name="hibernate.hbm2ddl.auto">create</property>
Hibernate: 
    
    drop table employee_table cascade constraints
Hibernate: 
    
    drop table employee_two_addresses_table cascade constraints
Hibernate: 
    
    drop sequence hibernate_sequence
Hibernate: 
    
    drop sequence ID_SEQ_INIT_18_INCR_3
Hibernate: create sequence hibernate_sequence start with 1 increment by  1
Hibernate: create sequence ID_SEQ_INIT_18_INCR_3 start with 18 increment by  3
Hibernate: 
    
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
    
    create table employee_two_addresses_table (
       employee_id number(10,0) not null,
        address1_city_name varchar2(255 char),
        address1_postal_code number(19,0),
        address1_state_name varchar2(255 char),
        address1_street_name varchar2(50 char),
        address2_city_name varchar2(255 char),
        address2_postal_code number(19,0),
        address2_state_name varchar2(255 char),
        address2_street_name varchar2(60 char),
        date_of_joing timestamp,
        email varchar2(255 char),
        employee_name varchar2(200 char) not null,
        salary double precision,
        primary key (employee_id)
    )
Hibernate: 
    
    alter table employee_table 
       add constraint UK_2casspobvavvi9s23312f9mhm unique (email)
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    insert 
    into
        employee_two_addresses_table
        (address1_city_name, address1_postal_code, address1_state_name, address1_street_name, address2_city_name, address2_postal_code, address2_state_name, address2_street_name, date_of_joing, email, employee_name, salary, employee_id) 
    values
        (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
*/	