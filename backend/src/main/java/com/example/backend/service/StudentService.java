package com.example.backend.service;

import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll(){
        return (List<Student>) studentRepository.findAll();
    }
}
