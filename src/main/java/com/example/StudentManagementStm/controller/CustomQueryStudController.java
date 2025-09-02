package com.example.StudentManagementStm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementStm.entity.Student;
import com.example.StudentManagementStm.service.CustomQueryStudService;

@RestController
public class CustomQueryStudController {
	
	@Autowired
	CustomQueryStudService queryService;
	
	//get All Student by using sql query
	//http://localhost:8080/getAllStudents
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		return queryService.getAllStudents();
		
	}
	//get All Student by using hql query
	//http://localhost:8080/getAllStudentsHql
	@GetMapping("/getAllStudentsHql")
	public List<Student> getAllStudentsHql(){
		return queryService.getAllStudentsHql();
		
	}
	
	//fetch a particular data using SQL
	//http://localhost:8080/getName?dept=java
	@GetMapping("/getName")
	public List<Student>getName(@RequestParam("dept") String dept){
		return queryService.getName(dept);
		
	}
	
	//fetch a particular data using HQL
	//http://localhost:8080/getNames?dept=dotnet
	@GetMapping("/getNames")
	public List<Student>getNames(@RequestParam("dept") String dept){
		return queryService.getNames(dept);
		
	}
	//update a student by using sql 
	//http://localhost:8080/updateStudent/6
	@PutMapping("/updateStudent/{id}")
	public void updateStudent(@PathVariable Integer id){
		queryService.updateStudent(id);
	}
	
	//delete a student by using sql 
	//http://localhost:8080/deleteStudent/6
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		queryService.deleteStudent(id);
	}
 
	//insert a student by using sql 
		//http://localhost:8080/CreateStudent
		@PostMapping("/createStudent/id/{id}/name/{n}/batch/{b}/email/{e}/age/{age}/marks/{marks}/dept/{dept}/active/{active}")
	public void createStudent(@PathVariable Integer id,
		
			@PathVariable String name,
			@PathVariable String batch,
			@PathVariable String email,
			@PathVariable Integer age,
			@PathVariable Integer marks,
			@PathVariable String dept,
			@PathVariable boolean active){
		queryService.createStudent(id,name,batch,email,age,marks,dept,active);
	}
}
