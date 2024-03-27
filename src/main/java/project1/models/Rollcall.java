package project1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Rollcall {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String matricule;
	@Column
	private String fName;
	@Column
	private String mName;
	@Column
	private String lName;
	@Column
	private int hours;
	
	
	public Rollcall(String matricule, String fName, String mName, String lName) {
		this.matricule = matricule;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
	}

	public int getId() {
		return id;
	}
	
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	@OneToOne
	@JoinColumn(name = "class_id", referencedColumnName = "id", nullable=false)
	private Classroom classroom;
	
	

}
