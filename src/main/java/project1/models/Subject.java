package project1.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Subject {
	
	@Id
	@Column
	private String code = UUID.randomUUID().toString();
	@Column
	private String name;
	@Column
	private int totalHours;
	
	public Subject() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public String getCode() {
		return code;
	}
	
	@ManyToMany(mappedBy = "subjects")
	private Set<Student> students = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable=false)
	private Teacher teacher;
	
	@ManyToMany
	@JoinTable( name = "subjects_classrooms",
				joinColumns = {@JoinColumn(name = "subject_ids", referencedColumnName = "code")},
				inverseJoinColumns = {@JoinColumn(name = "class_ids", referencedColumnName = "id")})
	private Set<Classroom> classrooms = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "subjects_logbooks",
				joinColumns = {@JoinColumn(name = "subject_id", referencedColumnName = "code")},
				inverseJoinColumns = {@JoinColumn(name = "logbook_id", referencedColumnName = "id")})
	private Set<Logbook> logbooks = new HashSet<>();
	
	
	

}
