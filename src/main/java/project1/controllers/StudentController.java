package project1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project1.models.Student;
import project1.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//1- to get a single student record
	@GetMapping("/student/{matricule}")
	public Student getOne(@PathVariable String matricule){
		return studentService.getOne(matricule);
	}
	
	//2- to get all the students
	@GetMapping("/student")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	//3- to save a single student record
	@PostMapping("/student")
	public Student saveOne(@RequestBody Student student) {
		return studentService.saveOne(student);
	}
	
	//4- to save a list of students
	@PostMapping("/student/{studentList}")
	public List<Student> saveList(@PathVariable List<Student> studentList){
		return studentService.saveList(studentList);
	}
	
	//5- to delete a single student record
	@DeleteMapping("/student/{matricule}")
	public Optional<Student> deleteOne(@PathVariable String matricule){
		return studentService.deleteOne(matricule);
	}
	
	//6- to delete a list of student records
	@DeleteMapping("/student/{studentlist}")
	public Optional<List<Student>> deleteList(@PathVariable List<Student> studentList){
		return studentService.deleteList(studentList);
	}
	
	//7- to update a student record
	@PutMapping("/student")
	public Optional<Student> updateOne(@RequestBody Student student){
		return studentService.updateOne(student);
	}

}
