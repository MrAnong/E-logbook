package project1.models;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Logbook {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String chapter;
	@Column(columnDefinition = "TEXT")
	private String descriptions;
	@Column
	private LocalDateTime createdAt;
	
	public Logbook() {
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getDescription() {
		return descriptions;
	}

	public void setDescription(String description) {
		this.descriptions = description;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	@OneToOne
	@JoinColumn(name = "student_matricule", referencedColumnName = "matricule", nullable = false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable=false)
	private Teacher teacher;
	
	@ManyToMany(mappedBy = "logbooks")
	private Set<Subject> subjects = new HashSet<>();
	
	
	
	

}
