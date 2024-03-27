package project1.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Student {
	
	@Id
	@Column
	private String matricule = UUID.randomUUID().toString();
	
	@Column
	private String fName;
	@Column
	private String mName;
	@Column
	private String lName;
	@Column
	private LocalDate dob;
	@Column
	private String town;
	@Column
	private String pNumber;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private LocalDateTime createdAt = LocalDateTime.now();	
	
	
	public Student() {
	}


	public String getMatricule() {
		return matricule;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fname) {
		this.fName = fname;
	}
	
	public String getmName() {
		return mName;
	}
	
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public LocalDate getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getTown() {
		return town;
	}
	
	public void setTown(String town) {
		this.town = town;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getpNumber() {
		return pNumber;
	}
	
	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	@ManyToOne
	@JoinColumn(name = "class_id", referencedColumnName = "id", nullable = true)
	private Classroom classroom;
	
	@OneToOne(mappedBy = "student")
	private Logbook logbook;
	
	@ManyToMany
	@JoinTable( name = "students_subjects",
				joinColumns = {@JoinColumn(name = "matricules", referencedColumnName = "matricule")},
				inverseJoinColumns = {@JoinColumn(name = "subject_codes", referencedColumnName = "code")})
	private Set<Subject> subjects = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable=true)
	private Teacher teacher;
	
	@ManyToMany(mappedBy = "students")
	private Set<Authority> authorities = new HashSet<>();
	
	


}
