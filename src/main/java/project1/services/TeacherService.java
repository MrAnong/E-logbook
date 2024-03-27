package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project1.models.Teacher;
import project1.repositories.TeacherRepository;
import project1.utilities.constants.Roles;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	   public static PasswordEncoder TeacherPasswordEncoder() {
	       return new BCryptPasswordEncoder();
	   }
	
	@Transactional
	//1- to get a single teacher by its id
	public Optional<Teacher> getOne(int id) {
		Optional<Teacher> teacher = teacherRepository.findById((long) id);
		if(teacher == null) {
			return Optional.empty();
		}
		return teacher;
	}
	
	@Transactional
	//2- to get the list of teachers
	public List<Teacher> getAll(){
		return teacherRepository.findAll();
	}
	
	
	@Transactional
	//3- to save a teacher record
	public Teacher saveOne(Teacher teacher) {
		Teacher foundTeacher = teacherRepository.findByEmail(teacher.getEmail());
		if(foundTeacher == null) {
			teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
			teacher.setRole(Roles.TEACHER.getRole());
			return teacherRepository.save(teacher);
		}
		return null;
	}
	
	@Transactional
	//4- to save a list of teacher records into the database
	public List<Teacher> saveList(List<Teacher> teacherList){
		for(Teacher teacher1: teacherList) {
			teacherRepository.save(teacher1);
		}
		return teacherList;
	}
	
	@Transactional
	//5- to delete a particular teacher
	public Optional<Teacher> deleteOne(int id) {
		Optional<Teacher> teacher = teacherRepository.findById((long) id);
		if(teacher == null) {
			return Optional.empty();
		}
		teacherRepository.deleteById((long) id);
		return teacher;
	}
	
	//6- to delete a list of teachers
	public Optional<List<Teacher>> deleteList(List<Teacher> teacherList){
		List<Teacher> newList = teacherList;
		for(Teacher teacher1: teacherList) {
			Optional<Teacher> foundTeacher = teacherRepository.findById((long) teacher1.getId());
			if(foundTeacher == null) {
				return Optional.empty();
			}
			newList.add(teacher1);
			teacherRepository.deleteById((long) teacher1.getId());
			}
		return Optional.of(newList);
	}
	
	@Transactional
	//7- to update a particular teacher
	public Optional<Teacher> updateOne(Teacher teacher){
		Optional<Teacher> foundTeacher = teacherRepository.findById((long) teacher.getId());
		if(foundTeacher == null) {
			return Optional.empty();
		}
		teacherRepository.save(teacher);
		return Optional.of(teacher);
	}


}
