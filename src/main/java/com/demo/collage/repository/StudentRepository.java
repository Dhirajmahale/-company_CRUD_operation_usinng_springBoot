package com.demo.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.collage.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
