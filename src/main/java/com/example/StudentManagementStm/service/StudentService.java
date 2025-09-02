package com.example.StudentManagementStm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.StudentManagementStm.entity.Student;
import com.example.StudentManagementStm.repository.StudRepo;
import com.example.StudentManagementStm.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo repo;
	@Autowired
	StudRepo studrepo;
	
	public void addStudentData(Student stud) {
		repo.save(stud);
		
	}

	public void addStudents(List<Student> student) {
		repo.saveAll(student);
	}
	
	public Iterable<Student> viewStudent() {
		return repo.findAll();
	
	}
	
	public Optional<Student> findById(Integer id){
		return repo.findById(id);
		
	}

	public Optional<Student> findByIdAndName(Integer id, String name){
		return repo.findByIdAndName(id, name);
		
	}
	public void update(Integer id, Student s) { // new Data
		//fetch the old data from DB
		Student dbData = repo.findById(id).get();
		//update
		dbData.setBatch(s.getBatch());
		//save
		repo.save(dbData);
	}
	
	
	public void del(Integer id) {
		repo.deleteById(id);
	}

	

	public List<Student> findByDept(String dept) {
		
		return repo.findByDept(dept);
	}

	
	public List<Student> findByAge(Integer age) {
		
		return repo.findByAge(age);
	}

	public List<Student> findByName(String name) {
		
		return repo.findByName(name);
	}

	public List<Student> findByEmail(String email) {
		
		return repo.findByEmail(email);
	}

	public List<Student> findByMarksGreaterThanEqual(Integer marks) {
	
		return repo.findByMarksGreaterThanEqual(marks);
	}

	public List<Student> findByNameStartingWith(String name) {
		
		return repo.findByNameStartingWith(name);
	}

	public Optional<Student> findByDeptAndAge(String dept, Integer age) {
	
		return repo.findByDeptAndAge(dept, age);
	}

	public List<Student> findBynameContaining(String name) {

		return  repo.findBynameContaining(name);
	}


	public List<Student> getAllStudentsOrderByMarksDesc() {
	
		return repo.findAllByOrderByMarksDesc();
	}
	
	 public List<Student> getActiveStudents() {
	        return repo.findByActiveTrue();
	    }
	 
	 //sorting 
	 
	   public List<Student> getAllSortedByNameDesc() {
	        return studrepo.findAll(Sort.by("name").descending());
	    }

	   public List<Student> getSortedByJobAndSalary() {
	        Sort sort = Sort.by(Sort.Order.asc("dept"), Sort.Order.desc("marks"));
	        return studrepo.findAll(sort);
	    }
	   
	   
	  //pagination
	   

	    public Page<Student> getPaginated(int pageNo, int pageSize) {
	        PageRequest request = PageRequest.of(pageNo, pageSize);
	        return studrepo.findAll(request);
	    }

	    public Page<Student> getPaginatedAndSorted(int pageNo, int pageSize) {
	        Sort sort = Sort.by(Sort.Order.asc("dept"), Sort.Order.desc("marks"));
	        PageRequest request = PageRequest.of(pageNo, pageSize, sort);
	        return studrepo.findAll(request);
	    }
	    
	    //query by example

	    public List<Student> findByExample(Student stud) {
	        Example<Student> example = Example.of(stud);
	        return studrepo.findAll(example);
	    }
	    
	    public List<Student> findJavaDeptWithMarks() {
	    	Student emp = new Student();
	        emp.setDept("java");
	        emp.setMarks(98);
	        Example<Student> example = Example.of(emp);
	        return studrepo.findAll(example);
	    }
	}

	



	


