package project1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project1.data_transfer_objects.response_objects.StudentResponse;
import project1.data_transfer_objects.UsersDetails;
import project1.models.Student;
import project1.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	//0- to log a student in
	@GetMapping("/student/login")
	public StudentResponse loginStudent(@RequestBody UsersDetails usersDetails) {
		return studentService.loadsUserByUsername(usersDetails);
	}
	
	//1- to get a single student record
	@GetMapping("/student/matricule")
	public StudentResponse getOne(@RequestParam String matricule){
		return studentService.getOne(matricule);
	}
	
	//2- to get all the students
	@GetMapping("/student/getall")
	public List<Student> getAll(){
		return studentService.getAll();
	}
	
	//3- to register a single student record
	@PostMapping("/student/register")
	public StudentResponse saveOne(@RequestBody Student student) {
		return studentService.registerStudent(student);
	}
	
	//4- to save a list of students
	@PostMapping("/student/savelist")
	public List<Student> saveList(@RequestBody List<Student> studentList){
		return studentService.saveList(studentList);
	}
	
	//5- to delete a single student record
	@DeleteMapping("/student/delete")
	public StudentResponse deleteOne(@RequestParam String matricule){
		return studentService.deleteOne(matricule);
	}
	
	//6- to delete a list of student records
	@DeleteMapping("/student/deletelist")
	public Optional<List<Student>> deleteList(@RequestBody List<Student> studentList){
		return studentService.deleteList(studentList);
	}
	
	//7- to update a student record
	@PutMapping("/student/update")
	public StudentResponse updateOne(@RequestBody Student student){
		return studentService.updateOne(student);
	}

}
