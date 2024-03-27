package project1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import project1.data_transfer_objects.response_objects.StudentResponse;
import project1.data_transfer_objects.UsersDetails;
import project1.models.Student;
import project1.repositories.StudentRepository;
import project1.utilities.constants.Roles;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Bean
	   public static PasswordEncoder passwordEncoder() {
	       return new BCryptPasswordEncoder();
	   }
	
	
	

	
//	//0- to log a student in
//	@Transactional
//	public Student loginStudent(String email, String password) throws UsernameNotFoundException{
//		Student student = studentRepository.findByEmail(email);
//		if(student == null) {
//			throw new UsernameNotFoundException("Student not found");
//		}
//		String newPassword = passwordEncoder.encode(password);
//		String oldPassword = student.getPassword();
//		if(newPassword == oldPassword) {
//			return student;
//		}
////		return null;
//		List<GrantedAuthority> grantedAuthority = new ArrayList<>();
//		grantedAuthority.add(new SimpleGrantedAuthority("Allow"));
//		
//		return new User(email, password, grantedAuthority);
//	}
	
	
	//1- find a single student record from the database
	@Transactional
	public  StudentResponse getOne (String matricule) {
		Student student = studentRepository.findByMatricule(matricule);
		StudentResponse response = new StudentResponse();
		if(student == null) {
			response.setMessage("student does not exist");
			response.setStudent(null);
		}
			response.setMessage("student found");
			response.setStudent(student);
			return response;
	}
	
	//2- find the list of all students from the database
	@Transactional
	public List<Student> getAll(){
		return  studentRepository.findAll();
	}
	
	//3- save a single student record
	@Transactional
	public StudentResponse registerStudent(Student student) {
		Student foundStudent = studentRepository.findByEmail(student.getEmail());
		StudentResponse response = new StudentResponse();
		if(foundStudent == null) {
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		student.setRole(Roles.STUDENT.getRole());
		studentRepository.save(student);
		
		response.setMessage("successful registration");
		response.setStudent(student);
		return response;
		}
		response.setMessage("registration failed! user already exists");
		response.setStudent(null);
		return response;
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
	public StudentResponse deleteOne(String matricule){
		Student foundStudent = studentRepository.findByMatricule(matricule);
		StudentResponse response = new StudentResponse();
		if(foundStudent == null) {
			response.setMessage("delete failed! student doesn't exist");
			response.setStudent(null);
			return response;
		}
		studentRepository.deleteByMatricule(matricule);
		response.setMessage("student successfully deleted");
		response.setStudent(foundStudent);
		return response;
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
	public StudentResponse updateOne(Student student){
		Student foundStudent = studentRepository.findByEmail(student.getEmail());
		StudentResponse response = new StudentResponse();
		if(foundStudent == null) {
			response.setMessage("update failed! student does not exist");
			response.setStudent(null);
			return response;
		}
		studentRepository.save(student);
		response.setMessage("student has been successfully updated");
		response.setStudent(student);
		return response;
		
	}


	@Transactional
	public StudentResponse loadsUserByUsername(UsersDetails usersDetails) {
		Student optionalStudent = studentRepository.findByEmail(usersDetails.getEmail());
		StudentResponse loginResponse = new StudentResponse();
		if(optionalStudent == null) {
			loginResponse.setMessage("email doesnt exist");
			loginResponse.setStudent(null);
			return loginResponse;
		}
		Student student = optionalStudent;
		String password = usersDetails.getPassword();
		String encodedPassword = student.getPassword();
		
		Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
		
		if(isPwdCorrect) {
//			List<GrantedAuthority> grantedAuthority = new ArrayList<>();
//			grantedAuthority.add(new SimpleGrantedAuthority(student.getRole()));
//			return new User(student.getEmail(), student.getPassword(), grantedAuthority);
			loginResponse.setMessage("login successfull");
			loginResponse.setStudent(student);
			return loginResponse;
		}else {
		loginResponse.setMessage("wrong password, please try again");
		loginResponse.setStudent(null);
		return loginResponse;
	}
	}


}
