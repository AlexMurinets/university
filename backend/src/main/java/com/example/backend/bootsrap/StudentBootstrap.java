package com.example.backend.bootsrap;

import com.example.backend.model.Student;
import com.example.backend.model.Subject;
import com.example.backend.repository.StudentRepository;
import com.example.backend.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class StudentBootstrap implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student();
        student1.setName("Petea");
        student1.setUsername("Petea");
        student1.setPassword("password");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("Vasea Perednii");
        studentRepository.save(student2);

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


    }
}
