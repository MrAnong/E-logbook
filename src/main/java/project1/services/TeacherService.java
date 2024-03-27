package project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project1.data_transfer_objects.UsersDetails;
import project1.data_transfer_objects.response_objects.StudentResponse;
import project1.data_transfer_objects.response_objects.TeacherResponse;
import project1.models.Student;
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
	public TeacherResponse getOne(int id) {
		Optional<Teacher> teacher = teacherRepository.findById((long) id);
		TeacherResponse response = new TeacherResponse();
		if(teacher.isEmpty()) {
			response.setMessage("Sorry, teacher does not exist");
			response.setTeacher(null);
			return response;
		}
		response.setMessage("teacher found");
		Teacher foundTeacher = teacher.get();
		response.setTeacher(foundTeacher);
		return response;
	}
	
	@Transactional
	//2- to get the list of teachers
	public List<Teacher> getAll(){
		return teacherRepository.findAll();
	}
	
	
	@Transactional
	//3- to register a teacher record
	public TeacherResponse teacherRegister(Teacher teacher) {
		Teacher foundTeacher = teacherRepository.findByEmail(teacher.getEmail());
		TeacherResponse response = new TeacherResponse();
		if(foundTeacher == null) {
			teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
			teacher.setRole(Roles.TEACHER.getRole());
			 teacherRepository.save(teacher);
			 response.setMessage("successfully registered!");
			 response.setTeacher(teacher);
			 return response;
		}
		response.setMessage("registration failed! teacher already exists");
		response.setTeacher(null);
		return response;
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
	public TeacherResponse deleteOne(int id) {
		Optional<Teacher> teacher = teacherRepository.findById((long) id);
		TeacherResponse response = new TeacherResponse();
		if(teacher == null) {
			response.setMessage("delete failed! teacher does not exist");
			response.setTeacher(null);
			return response;
		}
		Teacher foundTeacher = teacher.get();
		teacherRepository.deleteById((long) id);
		response.setMessage("teacher deleted successfully");
		response.setTeacher(foundTeacher);
		return response;
		
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
	public TeacherResponse updateOne(Teacher teacher){
		Teacher foundTeacher = teacherRepository.findByEmail(teacher.getEmail());
		TeacherResponse response = new TeacherResponse();
		if(foundTeacher == null) {
			response.setMessage("update failed! teacher not found");
			response.setTeacher(null);
			return response;
			
		}
		teacherRepository.save(teacher);
		response.setMessage("teacher updated successfully");
		response.setTeacher(teacher);
		return response;
	}
	
	@Transactional
	public TeacherResponse loadsUserByUsername(UsersDetails usersDetails) {
		Teacher optionalTeacher = teacherRepository.findByEmail(usersDetails.getEmail());
		TeacherResponse loginResponse = new TeacherResponse();
		if(optionalTeacher == null) {
			loginResponse.setMessage("email doesnt exist");
			loginResponse.setTeacher(null);
			return loginResponse;
		}
		Teacher teacher = optionalTeacher;
		String password = usersDetails.getPassword();
		String encodedPassword = teacher.getPassword();
		
		Boolean isPwdCorrect = passwordEncoder.matches(password, encodedPassword);
		
		if(isPwdCorrect) {
//			List<GrantedAuthority> grantedAuthority = new ArrayList<>();
//			grantedAuthority.add(new SimpleGrantedAuthority(student.getRole()));
//			return new User(student.getEmail(), student.getPassword(), grantedAuthority);
			loginResponse.setMessage("login successfull");
			loginResponse.setTeacher(teacher);
			return loginResponse;
		}else {
		loginResponse.setMessage("wrong password, please try again");
		loginResponse.setTeacher(null);
		return loginResponse;
	}
	}


}
