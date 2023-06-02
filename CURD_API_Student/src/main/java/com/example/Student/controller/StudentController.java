package com.example.Student.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.model.Student;
import com.example.Student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	StudentService studService;

	//CREATE
	@RequestMapping(value="/Students", method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student em){
		return studService.createStudent(em);
	}

	//READ
	@RequestMapping(value="/Students", method=RequestMethod.GET)
	public List<Student> readStudent(){

		return studService.getStudent();

	}



	//UPDATE
	@RequestMapping(value="/Students/{stud_Id}", method=RequestMethod.PUT)
	public Student readStudents(@PathVariable(value = "stud_Id") Long id, @RequestBody Student empDetails) {
		
		return studService.updateStudent(id, empDetails);
	}

	//DELETE
	@RequestMapping(value="/Students/{stud_Id}", method=RequestMethod.DELETE)
	public void deleteStudents(@PathVariable(value = "stud_Id") Long id) {
		studService.delStudent(id);
	}







}
