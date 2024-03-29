package project1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project1.models.Logbook;
import project1.services.LogbookService;

@RestController
@RequestMapping("/api")
public class LogbookController {
	
	@Autowired
	private LogbookService logbookService;
	
	//1- path to get a single logbook record
	@GetMapping("/logbook/id")
	public Optional<Logbook> getOne(@RequestBody int id){
		return logbookService.getOne(id);
	}
	
	//2- to get a list of all the logbooks
	@GetMapping("/logbook/getall")
	public List<Logbook> getAll(){
		return logbookService.getAll();
	}
	
	//3- to save a single logbook record
	@PostMapping("/logbook/save")
	public Logbook saveOne(@RequestBody Logbook logbook) {
		return logbookService.saveOne(logbook);
	}
	
	//4- to save a list of logbooks
	@PostMapping("/logbooksavelist")
	public List<Logbook> saveList(@RequestBody List<Logbook> logbookList){
		return logbookService.saveList(logbookList);
	}
	
	//5- to delete a single logbook record
	@DeleteMapping("/logbook/delete")
	public Optional<Logbook> deleteOne(@RequestBody int id){
		return logbookService.deleteOne(id);
	}
	
	//6- to delete a list of logbooks
	@DeleteMapping("/logbook/deleteList")
	public Optional<List<Logbook>> deleteList(@RequestBody List<Logbook> logbookList){
		return logbookService.deleteList(logbookList);
	}
	
	//7- to update a logbook record
	@PutMapping("/logbook/update")
	public Optional<Logbook> updateOne(@RequestBody Logbook logbook){
		return logbookService.updateOne(logbook);
	}

}
