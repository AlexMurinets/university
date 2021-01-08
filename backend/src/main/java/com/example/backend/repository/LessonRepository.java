package com.example.backend.repository;

import com.example.backend.model.Lesson;
import com.example.backend.model.Subject;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    List<Lesson> findBySubject(Subject subject);
}
