package com.fabien.student.controller;

import com.fabien.student.model.Student;
import com.fabien.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
