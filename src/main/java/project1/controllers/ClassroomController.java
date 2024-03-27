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
import project1.services.ClassroomService;

@RestController
@RequestMapping("/api")
public class ClassroomController {
	
	@Autowired
	private ClassroomService classroomService;
	
	//1- to get a single classroom record
	@GetMapping("/classroom/id")
	public Optional<Classroom> getOne(@RequestBody int id) {
		return classroomService.getOne(id);
	}
	
	//2- to get all the classrooms
	@GetMapping("/classroom/getall")
	public List<Classroom> getAll(){
		return classroomService.getAll();
	}
	
	//3- to save a single classroom record
	@PostMapping("/classroom/save")
	public Classroom save(@RequestBody Classroom classroom) {
		return classroomService.saveOne(classroom);
	}
	
	//4- to save a list of classrooms
	@PostMapping("/classroom/savelist")
		public List<Classroom> saveList(@RequestBody List<Classroom> classroomList){
			return classroomService.saveList(classroomList);
		}
	
	//5- to delete a single classroom record
	@DeleteMapping("/classroom/delete")
	public Optional<Classroom> deleteOne(@RequestBody int id) {
		return classroomService.deleteOne(id);
	}
	
	//6- to delete a list of classroom records
	@DeleteMapping("/classroom/deletelist")
	public Optional<List<Classroom>> deleteList(@RequestBody List<Classroom> classroomList){
		return classroomService.deleteList(classroomList);
	}
	
	//7- to update a classroom record
	@PutMapping("/classroom/update")
	public Optional<Classroom> updateOne(@RequestBody Classroom classroom){
		return classroomService.updateOne(classroom);
	}
	
	}
	
	//TOTO: update and delete mappings
	

