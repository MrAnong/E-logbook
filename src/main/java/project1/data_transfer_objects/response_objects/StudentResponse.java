package project1.data_transfer_objects.response_objects;

import project1.models.Student;

public class StudentResponse {
	
	private String message;
	private Student student;
	
	
	public StudentResponse() {
		super();
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
