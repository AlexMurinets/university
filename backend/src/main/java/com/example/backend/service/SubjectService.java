package com.example.backend.service;

import com.example.backend.model.Subject;

import com.example.backend.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> findAll(){
        return (List<Subject>) subjectRepository.findAll();
    }
}
