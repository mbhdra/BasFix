package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Division {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int divisionId;
	
	@Column(unique=true, nullable = false)
	private String divisionName;

	public Division() {
		super();
	}

	public Division(String divisionName) {
		super();
		this.divisionName = divisionName;
	}

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	@Override
	public String toString() {
		return "Division [divisionId=" + divisionId + ", divisionName=" + divisionName + "]";
	}	
}
