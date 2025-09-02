package com.example.StudentManagementStm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementStm.entity.Student;
import com.example.StudentManagementStm.repository.CustomQuerystudRepo;

@Service
public class CustomQueryStudService {
	
	@Autowired
	CustomQuerystudRepo queryRepo;
	
	public List<Student> getAllStudents(){
		return queryRepo.getAllStudents();
		
	}
	
	public List<Student> getAllStudentsHql(){
		return queryRepo.getAllStudentsHql();
		
	}

	public List<Student>getName(String dept){
		return queryRepo.getName(dept);
		
	}
	
	public List<Student>getNames(String dept){
		return queryRepo.getNames(dept);
		
	}
 
	public void updateStudent(Integer id) {
		queryRepo.updateStudent(id);
	}
	
	public void deleteStudent(Integer id) {
		queryRepo.deleteStudent(id);
	}
	

	public void createStudent(Integer id,String name,String batch,String email,Integer age,Integer marks,String dept,boolean active) {
		queryRepo.createStudent(id,name,batch,email,age,marks,dept,active);
		
	}
}
