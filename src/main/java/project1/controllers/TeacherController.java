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

import project1.models.Classroom;
import project1.models.Teacher;
import project1.services.ClassroomService;
import project1.services.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	//1- to get a single teacher record
	@GetMapping("/teacher/{id}")
	public Optional<Teacher> getOne(@PathVariable int id) {
		return teacherService.getOne(id);
	}
	
	//2- to get all the teachers
	@GetMapping("/teacher")
	public List<Teacher> getAll(){
		return teacherService.getAll();
	}
	
	//3- to save a single teacher record
	@PostMapping("/teacher")
	public Teacher save(@RequestBody Teacher teacher) {
		return teacherService.saveOne(teacher);
	}
	
	//4- to save a list of teachers
	@PostMapping("/teacher/{teacherList}")
		public List<Teacher> saveList(@PathVariable List<Teacher> teacherList){
			return teacherService.saveList(teacherList);
		}
	
	//5- to delete a single teacher record
	@DeleteMapping("/teacher/{id}")
	public Optional<Teacher> deleteOne(@PathVariable int id) {
		return teacherService.deleteOne(id);
	}
	
	//6- to delete a list of teacher records
	@DeleteMapping("/teacher/{teacherList}")
	public Optional<List<Teacher>> deleteList(@PathVariable List<Teacher> teacherList){
		return teacherService.deleteList(teacherList);
	}
	
	//7- to update a teacher record
	@PutMapping("/teacher")
	public Optional<Teacher> updateOne(@RequestBody Teacher teacher){
		return teacherService.updateOne(teacher);
	}
	

}
