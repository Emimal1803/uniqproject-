package com.example.StudentManagementStm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementStm.entity.User;
import com.example.StudentManagementStm.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
    public void saveUser() {
        User u = new User();
        u.setUserid(10);
        u.setUsername("Emimal");
        userRepo.save(u);
    }
    
    public void updateUserNameById() {
         userRepo.updateUserNameById();
    }

}
