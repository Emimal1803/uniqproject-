package com.example.StudentManagementStm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementStm.entity.Student;
import com.example.StudentManagementStm.service.StudentService;
//controller+responsebody
@RestController
public class StudentController {
	
	@Autowired
	StudentService studService;
	
	
	@PostMapping("/addStudentData")
	
	public void addStudentData(@RequestBody Student stud) {
		studService.addStudentData(stud);
		
	}
	
	@PostMapping("/addStudents")
	
	public void addstudentsData(@RequestBody List<Student> student) {
		studService.addStudents(student);
		
	}
	
	@GetMapping("/getStudents")
	
	public Iterable<Student> viewStudent() {
		return studService.viewStudent();
		
	}
	
	//Query param..............................
	
	@GetMapping("/findById")
	
	public Optional<Student>findById(@RequestParam("id") Integer id){
		return studService.findById(id);
		
	}
	@GetMapping("/findByIdAndName")
	public Optional<Student>findByIdAndName(@RequestParam("id1")Integer id,@RequestParam("name") String name){
		return studService.findByIdAndName(id, name);
		
	}
	//path param...............................
	
	@GetMapping("/findByStudentId/id/{i}")
	public Optional<Student>findByStudentId(@PathVariable("i") Integer id){
		return studService.findById(id);
		
	}
	
	@GetMapping("/getAllStudents/{ids}")
	public Iterable <Student> getAllStudents(@PathVariable("ids") List<Integer> id){
		return studService.viewStudent();
		
	}
	//get a student by using id and name
	//http://localhost:8080/getIdAndName/id/1/name/emimal
	@GetMapping("/getIdAndName/id/{id2}/name/{name1}")
	public Optional <Student>getIdAndName(@PathVariable("id2")Integer id,@PathVariable("name1")String name){
		return studService.findByIdAndName(id, name);
		
	}
	//update a student by id
	//http://localhost:8080/update/2
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable Integer id, @RequestBody Student s){
		studService.update(id, s);
		return "Successfully Updated";
	}
	//Delete a student
	//http://localhost:8080/delete/1
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		studService.del(id);
		return "Deleted";
	} 
    //Retrieve all student by department
	//http://localhost:8080/findByDept/dept/java
	@GetMapping("/findByDept/dept/{dept}")
	public List<Student>findByDept(@PathVariable("dept") String dept){
		return studService.findByDept(dept);
		
	}
	//get a student by age
	//http://localhost:8080/findByAge/age/25
	@GetMapping("/findByAge/age/{age}")
	public List<Student>findByAge(@PathVariable("age") Integer age){
		return studService.findByAge(age);
	}
	
	//Retrieve all student by name
	//http://localhost:8080/findByname/name/guna
		@GetMapping("/findByName/name/{name}")
		public List<Student>findByName(@PathVariable("name") String name){
			return studService.findByName(name);
		}
		
	//Retrieve all student by name
	//http://localhost:8080/findByEmail/email/emi@gmail.com
	    @GetMapping("/findByEmail/email/{email}")
		public List<Student>findByEmail(@PathVariable("email") String email){
			return studService.findByEmail(email);
			}

	//Retrieve all students whose marks are greater than or equal to a given value
	    //http://localhost:8080/findByMarksGreaterThanEqual/88
	    @GetMapping("/findByMarksGreaterThanEqual/{marks}")
	    public List<Student> findByMarksGreaterThanEqual(@PathVariable("marks") Integer marks) {
			return studService.findByMarksGreaterThanEqual(marks);	
	    }
	    
	  //Retrieve all students whose names start with a given prefix.
	    //http://localhost:8080/findByNameStartingWith/name/E
	    @GetMapping("/findByNameStartingWith/name/{name}")
	    public List<Student> findByNameStartingWith(@PathVariable("name") String name) {
			return studService.findByNameStartingWith(name);
	
	    }
	    
	    //Retrieve students by both department and age.
	    //http://localhost:8080/findByDeptAndAge/java/25
	    @GetMapping("/findByDeptAndAge/{dept}/{age}")
		public Optional<Student>findByDeptAndAge(@PathVariable("dept")String dept,@PathVariable("age") Integer age){
			return studService.findByDeptAndAge(dept, age);
	    }
	    
	    //Search students whose names contain a given keyword.
	    //http://localhost:8080/findBynameContaining/na
	    @GetMapping("/findBynameContaining/{name}")
		public List<Student>findBynameContaining(@PathVariable("name") String name){
			return studService.findBynameContaining(name);
	    }
	    
	    //Retrieve all students sorted by their marks in descending order.
	    //http://localhost:8080/OrderByMarksDesc
	    @GetMapping("/OrderByMarksDesc")
	    public List<Student> getAllStudentsOrderByMarksDesc() {
	        return studService.getAllStudentsOrderByMarksDesc();
	    }
	    
	   // Retrieve all students who are active (boolean flag).
	    //http://localhost:8080/active
	    @GetMapping("/active")
	    public List<Student> getActiveStudents() {
	        return studService.getActiveStudents();
	    }
	    
	    //sorting (jpa repositary features)...................................
	    
	    @GetMapping("/sortedByNameDesc")
	    public List<Student> getAllSortedByNameDesc() {
	        return studService.getAllSortedByNameDesc();
	    }
	    
	    @GetMapping("/sortedByJobAndSalary")
	    public List<Student> getSortedByJobAndSalary() {
	        return studService.getSortedByJobAndSalary();
	    }
	    
	    //pagination...............................
	    @GetMapping("/paginated")
	    public Page<Student> getPaginated(@RequestParam(defaultValue = "0") int pageNo,
	                                  @RequestParam(defaultValue = "2") int pageSize) {
	        return studService.getPaginated(pageNo, pageSize);
	    }
	    
	    @GetMapping("/paginatedSorted")
	    public Page<Student> getPaginatedSorted(@RequestParam(defaultValue = "0") int pageNo,
	                                        @RequestParam(defaultValue = "2") int pageSize) {
	        return studService.getPaginatedAndSorted(pageNo, pageSize);
	    }
        //Query by example..............
	    @PostMapping("/search")
	    public List<Student> searchByExample(@RequestBody Student stud) {
	        return studService.findByExample(stud);
	    }

	    @GetMapping("/searchDeptMarks")
	    public List<Student> findJavaDeptWithMarks() {
	        return studService.findJavaDeptWithMarks();
	    }
	    
}
