package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project1.data_transfer_objects.response_objects.StudentResponse;
import project1.models.Rollcall;
import project1.models.Student;
import project1.repositories.RollcallRepository;
import project1.repositories.StudentRepository;

@Service
public class RollcallService {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RollcallRepository rollcallRepository;
	
	//1- to get a single rollcall record
	@Transactional
	public Optional<Rollcall> getOne(int id){
		Optional<Rollcall> rollcall = rollcallRepository.findById((long) id);
		if(rollcall == null) {
			return Optional.empty();
		}
		return rollcall;
	}
	
	//2- to get all rollcall records
	@Transactional
	public List<Rollcall> getAll(){
		return rollcallRepository.findAll();
	}
	
	//3- to save a single rollcall record
	@Transactional
	public  Rollcall saveOne(String matricule) {
		StudentResponse response = studentService.getOne(matricule) ;
		if(response.getStudent() == null) {
			return null;
		}
		String matricule1 = response.getStudent().getMatricule();
		String fName = response.getStudent().getfName();
		String mName = response.getStudent().getmName();
		String lName = response.getStudent().getlName();
		
		Rollcall rollcall = new Rollcall(matricule1, fName, mName, lName);
		
		rollcallRepository.save(rollcall);
		return rollcall;
	}
	
	//4- to save a list of rollcall records
	@Transactional
	public List<Rollcall> saveList(List<Student> studentList){
		List<Rollcall> rollcallList = null;
		for(Student student: studentList) {
			Rollcall rollcall = saveOne(student.getMatricule());
			rollcallList.add(rollcall);
		}
		return rollcallList;
	}
	
	//5- to delete a single rollcall records
	@Transactional
	public Optional<Rollcall> deleteOne(int id){
		Optional<Rollcall> foundRollcall = rollcallRepository.findById((long) id);
		if(foundRollcall == null) {
			return Optional.empty();
		}
		rollcallRepository.deleteById((long) id);
		return foundRollcall;
	}
	
	//6- to delete a list of rollcall reords
	public Optional<List<Rollcall>> deleteList(List<Rollcall> rollcallList){
		List<Rollcall> newList = rollcallList;
		for(Rollcall rollcall: rollcallList) {
		Optional<Rollcall> foundRollcall = rollcallRepository.findById((long) rollcall.getId());
		if(foundRollcall == null) {
			return Optional.empty();
		}
		newList.add(rollcall);
		rollcallRepository.deleteById((long) rollcall.getId());
	}
		return Optional.of(newList);
	}
	
	//7- to update a rollcall record
	public Optional<Rollcall> updateOne(Rollcall rollcall){
		Optional<Rollcall> foundRollcall = rollcallRepository.findById((long) rollcall.getId());
		if(foundRollcall == null) {
			return Optional.empty();
		}
		rollcallRepository.save(rollcall);
		return Optional.of(rollcall);
	}

}
