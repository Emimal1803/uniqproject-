package com.example.StudentManagementStm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagementStm.entity.Student;

public interface StudRepo extends JpaRepository<Student, Integer>{

}
