package com.example.backend.repository;

import com.example.backend.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
