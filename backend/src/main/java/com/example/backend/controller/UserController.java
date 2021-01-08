package com.example.backend.controller;

import com.example.backend.model.Subject;
import com.example.backend.model.User;
import com.example.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Setter @AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/professors")
    public List<User> getProfessors(){
        return userService.findProfessors();
    }

    @GetMapping("/students")
    public List<User> getStudents(){
        return userService.findStudents();
    }

    @PostMapping("/new_professor")
    public ResponseEntity<String> newProfessor(@RequestBody User user){
        userService.newUser(user);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @PostMapping("/new_student")
    public ResponseEntity<String> newStudent(@RequestBody User user){
        userService.newStudent(user);
        return new ResponseEntity<>("Successfully added.", HttpStatus.OK);
    }

    @PutMapping("/edit_professor/{id}")
    public ResponseEntity<String> editProfessor(@PathVariable Long id, @RequestBody User user){
        userService.editUser(id, user);
        return new ResponseEntity<>("Successfully updated.", HttpStatus.OK);
    }

    @DeleteMapping("/delete_professor/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }
}
