package com.example.StudentManagementStm.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	 @Id
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer userid;
	String username;
	
	@CreationTimestamp
	@Column(updatable=false)
	LocalDateTime createdDate;
	
	@UpdateTimestamp
	LocalDateTime updatedDate;

	public User() {
		super();
		
	}

	public User(Integer userid, String username, LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.userid = userid;
		this.username = username;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	
	

}
