package com.example.backend.bootsrap;

import com.example.backend.model.*;
import com.example.backend.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@AllArgsConstructor
@Component
public class StudentBootstrap implements CommandLineRunner {
    private final SubjectRepository subjectRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;
    private final ExamRepository examRepository;

    @Override
    public void run(String... args) throws Exception {

        Subject math = new Subject();
        math.setName("Math");
        math.setDescription("Best subject ever.");
        math.setImage("https://p3cdn4static.sharpschool.com/UserFiles/Servers/Server_770743/Image/Technology/Other%20Pictures/math.jpg");
        subjectRepository.save(math);

        Subject bd = new Subject();
        bd.setName("Data Base");
        bd.setDescription("Best subject forever.");
        bd.setImage("https://penmypaper.com/blog/wp-content/uploads/2020/05/Database-management-system.png");
        subjectRepository.save(bd);

        Subject python = new Subject();
        python.setName("Python");
        python.setDescription("Best subject forever ever.");
        python.setImage("https://miro.medium.com/max/670/1*F1oFCwu6_4ork7pWE__IIg.jpeg");
        subjectRepository.save(python);

        Role role1 = new Role();
        role1.setName(ERole.ROLE_USER);
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName(ERole.ROLE_MODERATOR);
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName(ERole.ROLE_ADMIN);
        roleRepository.save(role3);

        User petea = new User();
        petea.setName("Alexei Murinets");
        petea.setEmail("Leha@gmail.com");
        petea.setPassword("$2y$12$Ab8eHYjXZspgeYFg.4mQ.OpRr3W.vpLivmROyPbSGeOuHCIzrprJS");
        petea.setUsername("user");
        petea.getRoles().add(role1);
        userRepository.save(petea);

        User petea1 = new User();
        petea1.setName("Marina Messi");
        petea1.setEmail("Marina@gmail.com");
        petea1.setPassword("$2y$12$Ab8eHYjXZspgeYFg.4mQ.OpRr3W.vpLivmROyPbSGeOuHCIzrprJS");
        petea1.setUsername("marina");
        petea1.getRoles().add(role1);
        userRepository.save(petea1);

        User professor = new User();
        professor.setEmail("Johny@gmail.com");
        professor.setPassword("$2y$12$Ab8eHYjXZspgeYFg.4mQ.OpRr3W.vpLivmROyPbSGeOuHCIzrprJS");
        professor.setUsername("professor");
        professor.setName("Johny Cage");
        professor.getRoles().add(role2);
        userRepository.save(professor);

        User professor1 = new User();
        professor1.setEmail("Yourn@gmail.com");
        professor1.setPassword("$2y$12$Ab8eHYjXZspgeYFg.4mQ.OpRr3W.vpLivmROyPbSGeOuHCIzrprJS");
        professor1.setUsername("professor1");
        professor1.setName("Johny Sinus");
        professor1.getRoles().add(role2);
        userRepository.save(professor1);

        User admin = new User();
        admin.setEmail("Mamadmin@gmail.com");
        admin.setPassword("$2y$12$Ab8eHYjXZspgeYFg.4mQ.OpRr3W.vpLivmROyPbSGeOuHCIzrprJS");
        admin.setUsername("admin");
        admin.getRoles().add(role3);
        userRepository.save(admin);

        Task task1 = new Task();
        task1.setName("Laba1");
        task1.setDescription("Pupa and lupa");
        task1.setSubject(math);
        taskRepository.save(task1);

        Lesson lesson1 = new Lesson();
        lesson1.setName("Lesson1");
        lesson1.setDescription("Very good lesson");
        lesson1.setSubject(math);
        lessonRepository.save(lesson1);

        Exam exam1 = new Exam();
        exam1.setName("Test1");
        exam1.setDescription("First test");
        exam1.setSubject(math);
        examRepository.save(exam1);
    }
}
