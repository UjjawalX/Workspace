package org.practise.springpx.repository;

import java.util.List;

import org.practise.springpx.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
	List<Employee> findEmployeewithLastname(String lastname);
	List<Employee> findEmployeewithFirstname(String firstnames);
}
