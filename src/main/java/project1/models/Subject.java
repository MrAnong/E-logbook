package project1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Subject {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String code;
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
	
	
	

}
