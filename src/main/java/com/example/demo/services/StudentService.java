package com.example.demo.services;

import com.example.demo.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
//    private int nextId = 1;

    public StudentService() {
        // seed with a few students
        students.add(new Student(1, "Vishal", "CS"));
        students.add(new Student(2, "Priya", "Java"));
    }

    // READ all
    public List<Student> getAllStudents() {
        return students;
    }

    // READ one
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE
    public Student addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    // UPDATE
    public Student updateStudent(int id, Student updated) {
        Student existing = getStudentById(id);
        if (existing == null) return null;
        existing.setName(updated.getName());
        existing.setCourse(updated.getCourse());
        return existing;
    }

    // DELETE
    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getId() == id);
    }
}