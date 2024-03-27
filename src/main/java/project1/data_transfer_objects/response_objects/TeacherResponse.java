package project1.data_transfer_objects.response_objects;

import project1.models.Teacher;

public class TeacherResponse {
	
	private String message;
	private Teacher teacher;
	
	public TeacherResponse() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	

}
