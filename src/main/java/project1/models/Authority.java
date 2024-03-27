package project1.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Authority {
	
	@Id
	private Long id;
	
	private String name;

	public Authority() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany
	@JoinTable( name = "authority_student",
				joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name = "matricule", referencedColumnName = "matricule")})
	private Set<Student> students = new HashSet<>();
	
	@ManyToMany
	@JoinTable( name = "authority_teacher",
				joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "id")})
	private Set<Teacher> teachers = new HashSet<>();
	
	

}
