package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project1.models.Logbook;
import project1.repositories.LogbookRepository;

@Service
public class LogbookService {
	
	@Autowired
	private LogbookRepository LogbookRepository;
	
	//1- to get a single logbook record
	@Transactional
	public Optional<Logbook> getOne(int id){
		Optional<Logbook> logbook = LogbookRepository.findById((long) id);
		if(logbook == null) {
			return Optional.empty();
		}
		return logbook;
	}
	
	
	//2- to get all the logbooks from the database
	@Transactional
	public List<Logbook> getAll(){
		return LogbookRepository.findAll();
	}
	
	//3- to save a single logbook record
	@Transactional
	public Logbook saveOne(Logbook logbook) {
		return LogbookRepository.save(logbook);
	}
	
	//4- to save a list of logbook records in the database
	@Transactional
	public List<Logbook> saveList(List<Logbook> logbookList){
		for(Logbook logbook: logbookList) {
			LogbookRepository.save(logbook);
		}
		return logbookList;
	}
	
	//5- to delete a single logbook record
	@Transactional
	public Optional<Logbook> deleteOne(int id){
		Optional<Logbook> logbook = LogbookRepository.findById((long) id);
		if(logbook == null) {
			return Optional.empty();
		}
		LogbookRepository.deleteById((long) id);
		return logbook;
	}
	
	//6- delete a list of logbook records
	@Transactional
	public Optional<List<Logbook>> deleteList(List<Logbook> logbookList){
		List<Logbook> newList = logbookList;
		for(Logbook logbook: logbookList) {
			Optional<Logbook> foundLogbook = LogbookRepository.findById((long) logbook.getId());
			if(foundLogbook == null) {
				return Optional.empty();
			}
			logbookList.add(logbook);
			LogbookRepository.deleteById((long) logbook.getId());
		}
		return Optional.of(logbookList);
	}
	
	//7- to update an existing logbook record
	@Transactional
	public Optional<Logbook> updateOne(Logbook logbook){
		Optional<Logbook> foundLogbook = LogbookRepository.findById((long) logbook.getId());
		if(foundLogbook == null) {
			return Optional.empty();
		}
		LogbookRepository.save(logbook);
		return Optional.of(logbook);
 	}
}