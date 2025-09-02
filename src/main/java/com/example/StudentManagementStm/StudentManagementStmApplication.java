package com.example.StudentManagementStm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.StudentManagementStm.entity.User;
import com.example.StudentManagementStm.repository.UserRepo;

@SpringBootApplication
public class StudentManagementStmApplication {
	
	


	public static void main(String[] args) {
		ConfigurableApplicationContext context= SpringApplication.run(StudentManagementStmApplication.class, args);
	}

}
