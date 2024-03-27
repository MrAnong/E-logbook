package project1.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Classroom {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String className;
	
	public Classroom() {
	}
	

	public int getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@OneToMany(mappedBy = "classroom")
	private List<Student> classmembers;
	
	@OneToOne(mappedBy = "classroom")
	private Rollcall rollcall;
	
	@ManyToMany(mappedBy = "classrooms")
	private Set<Subject> subjects = new HashSet<>();
	
	
	

}
