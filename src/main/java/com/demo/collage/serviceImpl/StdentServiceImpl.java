package com.demo.collage.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.collage.dto.StudentRequestDTO;
import com.demo.collage.model.Student;
import com.demo.collage.repository.StudentRepository;
import com.demo.collage.service.StudentService;

@Service
public class StdentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	// create
	@Override
	public void saveStudent(StudentRequestDTO studentRequestDTO) {

		Student student = Student.builder().firstName(studentRequestDTO.getFirstName())
				.lastName(studentRequestDTO.getLastName()).Grade(studentRequestDTO.getGrade())
				.mark(studentRequestDTO.getMark()).build();

		studentRepository.save(student);

	}

	// read All
	@Override
	public List<Student> getAllStudent() {

		List<Student> list = studentRepository.findAll();
		return list;
	}

	@Override
	public Student getStudents(int id) {

		Optional<Student> optional = studentRepository.findById(id);

		Student student = optional.get();

		return student;
	}

	@Override
	public void deleteStudentDetails(int id) {

		studentRepository.deleteById(id);

	}

	@Override
	public void deleteAllStudent() {

		studentRepository.deleteAll();

	}

	@Override
	public void updateStudent(int id, StudentRequestDTO requestRequestDTO) {
		
		Student extitStudent=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student id dont found!"));
		
		//Student extitStudent=optional.get();
		
		extitStudent.setFirstName(requestRequestDTO.getFirstName());
		extitStudent.setLastName(requestRequestDTO.getLastName());
		extitStudent.setGrade(requestRequestDTO.getGrade());
		extitStudent.setMark(requestRequestDTO.getMark());
		
		studentRepository.save(extitStudent);
		
	}

}
