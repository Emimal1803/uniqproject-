package com.example.StudentManagementStm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagementStm.entity.User;



public interface UserRepo extends JpaRepository< User, Integer>{


	@Modifying
	@Transactional
	@Query(value = "UPDATE User SET username ='jeny' where userid='10'", nativeQuery = true)
	public void updateUserNameById();
	

}
