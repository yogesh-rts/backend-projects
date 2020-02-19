package com.springbootprojects.firstproject;

import java.util.List;
import java.util.Optional;

import javax.persistence.GeneratedValue;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;
	
	@GetMapping("/employees")
	List<EmployeeDetails> findAll(){
		return repo.findAll();
	}
	
	@GetMapping("/employees/{eid}")
	public Optional<EmployeeDetails> getEmployee(@PathVariable("eid") int eId ) {
		return repo.findById(eId);
	}
	
	@PostMapping("/employees")
	 public EmployeeDetails createEmployee(@RequestBody EmployeeDetails emp) {
		repo.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	 public EmployeeDetails createOrUpdateEmployee(@RequestBody EmployeeDetails emp) {
		repo.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employees/{eid}")
	 public void deleteEmployee(@PathVariable("eid") int eId ) {
		EmployeeDetails employee = repo.getOne(eId);
		System.out.println(employee);
		repo.delete(employee);
	}
	  
	
	@PatchMapping("/employees")
	 public EmployeeDetails UpdateEmployee(@RequestBody EmployeeDetails emp) {
		
		String [] ignoreProperties = new String[6];
		if(emp.geteAddress() == null) {
			ignoreProperties[0]="eAddress";
		}
		if(emp.geteName() == null) {
			ignoreProperties[1]="eName";
		}
		if(emp.geteAge() == 0) {
			ignoreProperties[2]="eAge";
		}
		if(emp.geteSalary() == 0.0) {
			ignoreProperties[3]="eSalary";
		}
		
		Optional<EmployeeDetails> olddata = repo.findById(emp.geteId());
		if(olddata.get()!=null)	{	
     		BeanUtils.copyProperties(emp,olddata.get(),ignoreProperties);
			repo.save(olddata.get());
			return olddata.get();
			
			
		}
		return null;
		
		
	}
		
}

