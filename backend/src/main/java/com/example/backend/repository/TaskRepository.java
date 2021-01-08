package com.example.backend.repository;

import com.example.backend.model.Subject;
import com.example.backend.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findBySubject(Subject subject);
}
