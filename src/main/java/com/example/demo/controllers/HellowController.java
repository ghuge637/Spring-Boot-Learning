package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;   // 👈 THIS LINE
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("students")
public class HellowController {

//    @GetMapping("/")
//    public String home() {
//        return "Hello! Welcome to my first Spring Boot app 🚀";
//    }
//
//    @GetMapping("/greet")
//    public String greet(@RequestParam String name) {
//        return "welcome, "+ name + " Greetings from Spring Boot!";
//    }
//    
//    @GetMapping("/about")
//    public String about()
//    {
//    	return "This is my Spring Boot learning journey!";
//    }
//    
//    @GetMapping("/getStudent")
//    public Student getStudent() {
//    	return new Student(1,"vishal","CS");
//    }
//    
//    @GetMapping("/student/{id}")
//    public Student student(@PathVariable int id) {
//    	return new Student(5,"priya","BE");
//    }
//    
//    @PostMapping("student")
//    public String addStudent(@RequestBody Student student) {
//    	 return "Received student: " + student.getName() 
//         + " | ID: " + student.getId() 
//         + " | Course: " + student.getCourse();
//    }
	
	
	
    @Autowired
	private StudentService studentservice;
	
	@GetMapping
	public List<Student> student(){
		return studentservice.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		Student student = studentservice.getStudentById(id);
		
		if(student == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student created = studentservice.addStudent(student);
		return ResponseEntity.status(201).body(created);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,
	                                              @RequestBody Student student) {
	    Student updated = studentservice.updateStudent(id, student);
	    if (updated == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(updated);
	}
}