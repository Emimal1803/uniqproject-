package com.example.StudentManagementStm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagementStm.entity.Student;

public interface CustomQuerystudRepo extends CrudRepository<Student, Integer>{
	
	//SQL Query
	@Query(value="Select * from Student", nativeQuery = true)//nativeQuery = true-> denotes sql query
	public List<Student> getAllStudents();
	
	
	//HQL query
	@Query(value="from Student")//for hql query --> it's dependent on entity class so case sensitive 
	public List<Student> getAllStudentsHql();
	
	
	//fetch the particular data for SQL
	@Query(value="select * from student where dept=:dept", nativeQuery = true)	
	public List<Student>getName(String dept);
		
	
	//fetch a particular data using HQL query
	@Query(value="from Student where dept=:dept")	
	public List<Student>getNames(String dept);
	
	//for delete and update you have to use @Modifying and to store that use @ Transactional
	
	
	//update a student by id using SQL
	@Modifying
	@Transactional//to store in DB
	@Query(value="update student set dept='analyst' where id=:id", nativeQuery = true)
	public void updateStudent(Integer id);
	
	//delete a student by id using SQL
		@Modifying
		@Transactional
		@Query(value="delete from student where id=:id", nativeQuery = true)
		public void deleteStudent(Integer id);
		
		
	//Insert a student by using SQL
		@Modifying
		@Transactional
		@Query(value="insert into student(id,name,batch,email,age,marks,dept,active)values(:id,:name,:batch,:email,:age,:marks,:dept,:active)", nativeQuery = true)
		public void createStudent(@Param("id")Integer id,
				@Param("name")String name,
				@Param("batch")String batch,
				@Param("email")String email,
				@Param("age")Integer age,
				@Param("marks")Integer marks,
				@Param("dept")String dept,
				@Param("active")boolean active
				);


	
}
