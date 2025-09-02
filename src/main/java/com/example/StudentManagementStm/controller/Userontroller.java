package com.example.StudentManagementStm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementStm.service.UserService;

@RestController
public class Userontroller {

	@Autowired
	UserService userService;
	
	@PostMapping("/save")
    public String saveUser() {
		userService.saveUser();
        return "User saved!";
    }
	
	  @PutMapping("/updateUserNameById")
	    public String updateUserNameById() {
		  userService.updateUserNameById();
	        return "User updated";
	  }
	  
}
