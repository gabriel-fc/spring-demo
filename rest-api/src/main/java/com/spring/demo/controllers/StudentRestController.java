package com.spring.demo.controllers;

import com.spring.demo.models.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	@PostConstruct
	private void loadData(){
		students = Arrays.asList(
				new Student("Joao", "Silva"),
				new Student("Maria", "Gomes"),
				new Student("Abcd", "Defg"));
	}

	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id){
		System.out.println(id);
		return students.get(id);
	}

	@PostMapping("/addStudent")
	public void addStudent(){

	}

	
}
