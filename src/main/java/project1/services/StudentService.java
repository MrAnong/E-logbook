package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.transaction.Transactional;
import project1.models.Student;
import project1.repositories.StudentRepository;

public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	//1- find a single student record from the database
//	public Optional<Student> getOne (String matricule) {
//		Student student = studentRepository.findByMatricule(matricule);
//		if(student == null) {
//			return Optional.empty();
//		}
//		return Optional.of(student);
//	}
	@Transactional
	public  Student getOne (String matricule) {
		Student student = studentRepository.findByMatricule(matricule);
		if(student == null) {
		  return null;
		}
		return student;
	}
	
	//2- find the list of all students from the database
	@Transactional
	public List<Student> getAll(){
		return  studentRepository.findAll();
	}
	
	//3- save a single student record
	@Transactional
	public Student saveOne(Student student) {
		return studentRepository.save(student);
	}
	
	//4- save a list of students in the database
	@Transactional
	public List<Student> saveList(List<Student> student){
		for(Student student1: student) {
			student.add(studentRepository.save(student1));
		}
		return student;
	}
	
	//5- delete a single student record from the database
	@Transactional
	public Optional<Student> deleteOne(String matricule){
		Student foundStudent = studentRepository.findByMatricule(matricule);
		if(foundStudent == null) {
			return Optional.empty();
		}
		studentRepository.deleteByMatricule(matricule);
		return Optional.of(foundStudent);
	}
	
	//6- delete a list of students from the database
	@Transactional
	public Optional<List<Student>> deleteList(List<Student> studentList){
		List<Student> newList = studentList;
		for(Student student1: studentList) {
			Student foundStudent = studentRepository.findByMatricule(student1.getMatricule());
			if(foundStudent == null) {
				return Optional.empty();
				}
			newList.add(student1);
			studentRepository.deleteByMatricule(student1.getMatricule());
		}
		return Optional.of(newList);
		
	}

	
	//7- update a student record in the database
	@Transactional
	public Optional<Student> updateOne(Student student){
		Student foundStudent = studentRepository.findByMatricule(student.getMatricule());
		if(foundStudent == null) {
			return Optional.empty();
		}
		studentRepository.save(student);
		return Optional.of(student);
		
	}
}
