package com.example.backend.controller;

import com.example.backend.model.Subject;
import com.example.backend.model.Task;
import com.example.backend.service.SubjectService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/subjects")

public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/all")
    public List<Subject> getAll(){
        return subjectService.findAll();
    }

    @GetMapping("/{subjectId}")
    public Optional<Subject> getSubjectInfo(@PathVariable Long subjectId)
    {
        return subjectService.findById(subjectId);
    }

    @GetMapping("/task/{taskId}")
    public Optional<Task> getTaskInfo(@PathVariable Long taskId)
    {
        return subjectService.findTaskById(taskId);
    }
}
