package com.demo.collage.service;

import java.util.List;

import com.demo.collage.dto.StudentRequestDTO;
import com.demo.collage.model.Student;

public interface StudentService  {

	public void saveStudent(StudentRequestDTO studentRequestDTO);

	public List<Student> getAllStudent();

	public Student getStudents(int id);

	public void deleteStudentDetails(int id);

	public void deleteAllStudent();

	public void updateStudent(int id, StudentRequestDTO resquestRequestDTO);

	
}
