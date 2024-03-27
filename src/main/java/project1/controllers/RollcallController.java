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

import project1.models.Rollcall;
import project1.models.Student;
import project1.services.RollcallService;

@RestController
@RequestMapping("/api")
public class RollcallController {
	
	@Autowired
	private RollcallService rollcallService;
	
	//1- to get a single rollcall record
	@GetMapping("/rollcall/id")
	public Optional<Rollcall> getOne(@RequestBody int id){
		return rollcallService.getOne(id);
	}
	
	//2- to get all the rollcall records
	@GetMapping("/rollcall/getall")
	public List<Rollcall> getAll(){
		return rollcallService.getAll();
	}
	
	//3- to save a single rollcall record
	@PostMapping("/rollcall/save")
	public Rollcall saveOne(@RequestBody String matricule) {
		return rollcallService.saveOne(matricule);
	}
	
	
	//4- to save a list of rollcall records
	@PostMapping("/rollcall/savelist")
	public List<Rollcall> saveList(@RequestBody List<Student> studentList){
		return rollcallService.saveList(studentList);
	}
	
	//5- to delete a single rollcall record
	@DeleteMapping("/rollcall/delete")
	public Optional<Rollcall> deleteOne(@RequestBody int id){
		return rollcallService.deleteOne(id);
	}
	
	//6- to delete a list of rollcall records
	@DeleteMapping("/rollcall/deletelist")
	public Optional<List<Rollcall>> deleteList(@RequestBody List<Rollcall> rollcallList){
		return rollcallService.deleteList(rollcallList);
	}
	
	//7- to update a single rollcall record
	@PutMapping("/rollcall/update")
	public Optional<Rollcall> updateOne(@RequestBody Rollcall rollcall){
		return rollcallService.updateOne(rollcall);
	}

}
