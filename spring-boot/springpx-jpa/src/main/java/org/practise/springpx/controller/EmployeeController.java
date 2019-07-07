package org.practise.springpx.controller;

import java.util.List;
import java.util.Optional;

import org.practise.springpx.dto.EmployeeDto;
import org.practise.springpx.model.Employee;
import org.practise.springpx.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository erepos;
	@GetMapping(path = "/")
	public Iterable<Employee> getAllEmployees() {
		return erepos.findAll();
	}
	@GetMapping(path = "/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return erepos.findById(id).get();
	}
	@PostMapping(path = "/")
	public void addEmployee(@RequestBody Employee eto) {
		erepos.save(eto);
	}
	@PutMapping(path = "/")
	public void modifyEmployee(@RequestBody Employee eto) {
		Optional<Employee> o = erepos.findById(eto.getId());
		if(o.isPresent())
			erepos.save(eto);
	}
	@DeleteMapping(path = "/{id}" )
	public void deleteEmployee(@PathVariable int id) {
		Optional<Employee> o = erepos.findById(id);
		if(o.isPresent())
			erepos.delete(o.get());
	}
	@GetMapping(path = "/lastname")
	public List<Employee> findLastname(@RequestParam String lname) {
		return erepos.findEmployeewithLastname(lname);
	}
	@GetMapping(path = "/firstname")
	public List<Employee> findFirstname(@RequestParam(value = "fname" , required = true) String firstname) {
		return erepos.findEmployeewithFirstname(firstname);
		
	}
	@GetMapping(path = "/firstnamelastname")
	public List<Employee> findFirstname(@RequestParam(value = "fname" , required = true) String firstname,@RequestParam(value = "lname", required = true) String lname) {
		
		return erepos.findEmplyeewithFirstorlastname(firstname, lname);
		
	}
}
