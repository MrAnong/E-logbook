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

import project1.models.Subject;
import project1.services.SubjectService;

@RestController
@RequestMapping("/api")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	//1- to get a single subject record
	@GetMapping("/subject/{code}")
	public Optional<Subject> getOne(@PathVariable String code){
		return subjectService.getOne(code);
	}
	
	//2- to get all the subjects
	@GetMapping("/subject")
	public List<Subject> getAll(){
		return subjectService.getAll();
	}
	
	//3- to save a single subject record
	@PostMapping("/subject")
	public Subject saveOne(@RequestBody Subject subject) {
		return subjectService.saveOne(subject);
	}
	
	//4- to save a list of subjects
	@PostMapping("/subject/{subjectList}")
	public List<Subject> saveList(@PathVariable List<Subject> subjectList){
		return subjectService.saveList(subjectList);
	}
	
	//5- to delete a single student record
	@DeleteMapping("/subject/{code}")
	public Optional<Subject> deleteOne(@PathVariable String code){
		return subjectService.deleteOne(code);
	}
	
	//6- to delete a list of subject records
	@DeleteMapping("/subject/{subjectlist}")
	public Optional<List<Subject>> deleteList(@PathVariable List<Subject> subjectList){
		return subjectService.deleteList(subjectList);
	}
	
	//7- to update a subject record
	@PutMapping("/subject")
	public Optional<Subject> updateOne(@RequestBody Subject subject){
		return subjectService.updateOne(subject);
	}
}

