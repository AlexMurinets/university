package com.example.backend.service;

import com.example.backend.model.Subject;

import com.example.backend.model.Task;
import com.example.backend.repository.SubjectRepository;
import com.example.backend.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final TaskRepository taskRepository;

    public List<Subject> findAll(){
        return (List<Subject>) subjectRepository.findAll();
    }

    public Optional<Subject> findById(Long id){
        return subjectRepository.findById(id);
    }

    public  Optional<Task> findTaskById(Long id){return taskRepository.findById(id);}
}
