package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String image;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "subject")
    private List<Exam> exams;

    @OneToMany(mappedBy = "subject")
    private List<Task> tasks;

    @OneToOne
    private User user;

}
