package com.example.backend.controller;

import com.example.backend.model.Student;
import com.example.backend.service.StudentService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAll(){
        return studentService.findAll();
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello pupa";
    }
}
