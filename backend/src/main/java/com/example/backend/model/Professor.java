package com.example.backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;

    @ManyToMany
    private Set<Subject> subjects;


}
