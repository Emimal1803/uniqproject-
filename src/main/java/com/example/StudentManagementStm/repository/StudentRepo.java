package com.example.StudentManagementStm.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementStm.entity.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	public Optional<Student> findByIdAndName(Integer id, String name);
	public List<Student> findByDept(String dept);
	public List<Student> findByAge(Integer age);
	public List<Student> findByName(String name);
	public List<Student> findByEmail(String email);
	public List<Student> findByMarksGreaterThanEqual(Integer marks);
	public List<Student> findByNameStartingWith(String name);
	public Optional<Student> findByDeptAndAge(String dept, Integer age);
	public List<Student> findBynameContaining(String name);
	public List<Student> findAllByOrderByMarksDesc();
	public List<Student> findByActiveTrue();

}
