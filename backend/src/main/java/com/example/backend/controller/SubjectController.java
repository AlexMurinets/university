package com.example.backend.controller;

import com.example.backend.model.Subject;
import com.example.backend.service.SubjectService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/all")
    public List<Subject> getAll(){
        return subjectService.findAll();
    }
}
