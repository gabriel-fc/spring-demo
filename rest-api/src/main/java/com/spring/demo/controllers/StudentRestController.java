package com.spring.demo.controllers;

import com.spring.demo.exceptions.ExceptionResponse;
import com.spring.demo.exceptions.StudentNotFoundException;
import com.spring.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;
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
		try {
			return students.get(id);
		}catch (Exception e){
			throw new StudentNotFoundException("student not found");
		}
	}

	@PostMapping("/addStudent")
	public void addStudent(){

	}
	
}
