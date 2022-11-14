package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // service layer / business logic which gets all students from the data layer
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
