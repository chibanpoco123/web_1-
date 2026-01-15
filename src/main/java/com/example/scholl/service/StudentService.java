package com.example.scholl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholl.model.Student;
import com.example.scholl.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Thêm / cập nhật sinh viên
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Xóa sinh viên
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }

    // Tìm theo tên
    public List<Student> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    // Lấy tất cả sinh viên
    public List<Student> getAll() {
        return repository.findAll();
    }

    // Lấy sinh viên theo ID
    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }
}
