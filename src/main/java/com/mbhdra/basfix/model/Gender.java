package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gender {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int genderId;
	
	@Column(unique=true, nullable = false)
	private String genderName;

	public Gender() {
		super();
	}
	
	public Gender(int genderId, String genderName) {
		super();
		this.genderId = genderId;
		this.genderName = genderName;
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	@Override
	public String toString() {
		return "Gender [genderId=" + genderId + ", genderName=" + genderName + "]";
	}
}