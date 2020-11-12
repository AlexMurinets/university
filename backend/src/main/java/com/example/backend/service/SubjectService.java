package com.example.backend.service;

import com.example.backend.model.Subject;

import com.example.backend.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> findAll(){
        return (List<Subject>) subjectRepository.findAll();
    }

    public Optional<Subject> findById(Long id){
        return subjectRepository.findById(id);
    }
}
