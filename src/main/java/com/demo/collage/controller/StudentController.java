package com.demo.collage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.collage.dto.StudentRequestDTO;
import com.demo.collage.model.Student;
import com.demo.collage.service.StudentService;

@RestController
@RequestMapping(path = "student/Details")
public class StudentController {

	@Autowired
	private StudentService StudentService;

	// create
	@PostMapping(path = "add/Student")
	public ResponseEntity<?> AddStudentDetails(@RequestBody StudentRequestDTO studentRequestDTO) {

		StudentService.saveStudent(studentRequestDTO);

		return new ResponseEntity<>("Student details save successfully", HttpStatus.OK);
	}

	// All get student details !
	@GetMapping(path = "get/All/Student")
	public ResponseEntity<?> getAllDetails() {

		List<Student> list = StudentService.getAllStudent();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// get Student using id

	@GetMapping(path = "get/{id}/details")
	public ResponseEntity<Student> getStudentDetails(@PathVariable int id) {

		Student student = StudentService.getStudents(id);

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	// delete student details !

	@DeleteMapping(path = "/{id}/remove")
	public ResponseEntity<?> removeStudent(@PathVariable int id) {

		StudentService.deleteStudentDetails(id);

		return new ResponseEntity<>("Delete Student successfully..!", HttpStatus.OK);
	}
	
	//delete all Student Data..!
	
	@DeleteMapping(path ="all/delete")
	public ResponseEntity<?> removeAllStudent(){
		
		StudentService.deleteAllStudent();
		
		return new ResponseEntity<>("Delete All Student Data!",HttpStatus.OK);
	}
	
	//update student data..!
	@PutMapping(path="/{id}/update")
	public ResponseEntity<?> updateStudentData(@PathVariable int id,@RequestBody StudentRequestDTO resquestRequestDTO){

		StudentService.updateStudent(id,resquestRequestDTO);		
		return new ResponseEntity<>("Student details Updated..!",HttpStatus.OK);
	}

}
