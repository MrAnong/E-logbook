package project1.models;

import java.time.LocalDate;
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
import jakarta.persistence.Table;

@Entity
public class Teacher {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
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
	private String role = "standard";
	
	
	public Teacher() {
	}
	
	public int getId() {
		return id;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
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
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "teacher")
	private List<Student> studentsUpgraded;
	
	@OneToMany(mappedBy = "teacher")
	private List<Subject> subjctsTaught;
	
	@OneToMany(mappedBy = "teacher")
	private List<Logbook> logbooksSigned;
	
	@ManyToMany(mappedBy = "teachers")
	private Set<Authority> authorities = new HashSet<>();
	

}
