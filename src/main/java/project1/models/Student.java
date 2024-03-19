package project1.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Student {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String matricule;
	
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
	private String email;
	@Column
	private String pNumber;
	@Column
	private String gender;
	@Column
	private String role;
	@Column
	private LocalDateTime createdAt;
	
	
	
	public Student() {
	}


	public String getMatricule() {
		return matricule;
	}
	
	public String getFname() {
		return fName;
	}
	
	public void setFname(String fname) {
		this.fName = fname;
	}
	
	public String getMname() {
		return mName;
	}
	
	public void setmName(String mName) {
		this.mName = mName;
	}
	
	public String getLname() {
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	


}
