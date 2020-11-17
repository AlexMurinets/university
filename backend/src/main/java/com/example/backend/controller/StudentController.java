package com.example.backend.controller;

import com.example.backend.model.Student;
import com.example.backend.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Setter
@RestController
@RequestMapping("/users")
public class StudentController {


    private StudentRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/record")
    public void signUp(@RequestBody Student user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

}