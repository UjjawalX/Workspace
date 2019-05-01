package org.practise.springpx.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Employee.findEmployeewithLastname", query = "select e from Employee e where lastname = ?1"),
		@NamedQuery(name = "Employee.findEmployeewithFirstname", query = "select e from Employee e where firstname = ?1") })
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String firstname;
	String lastname;
	Date doj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
}
