package com.example.scholl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.scholl.model.Student;
import com.example.scholl.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {

    @Autowired

    private StudentService service;

    // ✅ API thêm sinh viên (CHUẨN)
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // 2. API xóa sinh viên (POST)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }

    // 3. Tìm sinh viên theo tên
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return service.findByName(name);
    }

    // 4. Lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // 5. Lấy danh sách sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAll();
    }

    // 6. Cập nhật sinh viên (POST)
    @PostMapping("/update/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student student) {

        Student existingStudent = service.getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            return service.addStudent(existingStudent);
        }
        return null;
    }
}
