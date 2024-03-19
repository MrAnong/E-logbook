package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project1.models.Classroom;
import project1.repositories.ClassroomRepository;

@Service
public class ClassroomService {
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	
	@Transactional
	//1- to get a single classroom by its id
	public Optional<Classroom> getOne(int id) {
		Optional<Classroom> classroom = classroomRepository.findById((long) id);
		if(classroom == null) {
			return Optional.empty();
		}
		return classroom;
	}
	
	@Transactional
	//2- to get the list of classrooms
	public List<Classroom> getAll(){
		return classroomRepository.findAll();
	}
	
	
	@Transactional
	//3- to save a classroom record
	public Classroom saveOne(Classroom classroom) {
		return classroomRepository.save(classroom);
	}
	
	@Transactional
	//4- to save a list of classroom records into the database
	public List<Classroom> saveList(List<Classroom> classroom){
		for(Classroom classroom1: classroom) {
			classroomRepository.save(classroom1);
		}
		return classroom;
	}
	
	@Transactional
	//5- to delete a particular classroom
	public Optional<Classroom> deleteOne(int id) {
		Optional<Classroom> classroom = classroomRepository.findById((long) id);
		if(classroom == null) {
			return Optional.empty();
		}
		classroomRepository.deleteById((long) id);
		return classroom;
	}
	
	//6- to delete a list of classrooms
	public Optional<List<Classroom>> deleteList(List<Classroom> classroomList){
		List<Classroom> newList = classroomList;
		for(Classroom classroom1: classroomList) {
			Optional<Classroom> foundClassroom = classroomRepository.findById((long) classroom1.getId());
			if(foundClassroom == null) {
				return Optional.empty();
			}
			newList.add(classroom1);
			classroomRepository.deleteById((long) classroom1.getId());
			}
		return Optional.of(newList);
	}
	
	@Transactional
	//7- to update a particular classroom
	public Optional<Classroom> updateOne(Classroom classroom){
		Optional<Classroom> foundClassroom = classroomRepository.findById((long) classroom.getId());
		if(foundClassroom == null) {
			return Optional.empty();
		}
		classroomRepository.save(classroom);
		return Optional.of(classroom);
	}

}
