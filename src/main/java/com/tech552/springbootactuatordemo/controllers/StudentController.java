package com.tech552.springbootactuatordemo.controllers;

import com.tech552.springbootactuatordemo.models.Student;
import com.tech552.springbootactuatordemo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student ){
        studentService.updateStudent(id, student);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
