package com.example.backend.repository;

import com.example.backend.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
