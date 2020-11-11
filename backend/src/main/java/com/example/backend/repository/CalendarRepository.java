package com.example.backend.repository;

import com.example.backend.model.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<Calendar, Long>{
}
