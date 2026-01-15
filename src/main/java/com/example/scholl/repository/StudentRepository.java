package com.example.scholl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scholl.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
}
