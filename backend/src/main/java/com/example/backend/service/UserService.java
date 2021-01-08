package com.example.backend.service;

import com.example.backend.model.ERole;
import com.example.backend.model.Role;
import com.example.backend.model.User;
import com.example.backend.repository.RoleRepository;
import com.example.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor @Setter
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public List<User> findProfessors(){
        List<Role> roles = new ArrayList<>();
        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(modRole);
        return userRepository.findUsersByRolesIn(roles);
    }

    public List<User> findStudents(){
        List<Role> roles = new ArrayList<>();
        Role modRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(modRole);
        return userRepository.findUsersByRolesIn(roles);
    }

    public void newUser(User user){
        user.getRoles().add(roleRepository.findByName(ERole.ROLE_MODERATOR).orElseThrow());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void newStudent(User user){
        user.getRoles().add(roleRepository.findByName(ERole.ROLE_USER).orElseThrow());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void editUser(Long id, User newUser){
        User oldUser = userRepository.findById(id).orElseThrow();
        oldUser.setPassword(newUser.getPassword());
        oldUser.setName(newUser.getName());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setEmail(newUser.getEmail());
        userRepository.save(oldUser);
    }

    public void deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

}
