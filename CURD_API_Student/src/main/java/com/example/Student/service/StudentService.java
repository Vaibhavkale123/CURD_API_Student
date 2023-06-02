package com.example.Student.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Repository.StudentRepository;
import com.example.Student.model.Student;


@Service
public class StudentService {
	@Autowired
StudentRepository studRepository;
	
	
	//Create
	public Student createStudent(Student stud) {
		System.out.println("Student added");
		return studRepository.save(stud);
	}
	//Read
	public List<Student> getStudent(){
		System.out.println("Request for Students");
		return studRepository.findAll();
	}
	
	
	///Delete
	public void delStudent(Long studId) {
		System.out.println("Student deleted");
		 studRepository.deleteById(studId);
	}
	
	//Update
	public Student updateStudent(Long studId, Student StudentDetails) {
		Student stud= studRepository.findById(studId).get();
		stud.setFirst_name(StudentDetails.getFirst_name());
		stud.setLast_name(StudentDetails.getLast_name());
		stud.setEmail_id(StudentDetails.getEmail_id());
	    System.out.println("Student updated");
		return studRepository.save(stud);
		
	
	}
}
