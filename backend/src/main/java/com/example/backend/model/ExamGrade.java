package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class ExamGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float grade;

    @OneToOne
    private User user;

    @OneToOne
    private Exam exam;

    @OneToOne
    private DBFile dbFile;
}
