package com.example.backend.repository;

import com.example.backend.model.Exam;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {
}
