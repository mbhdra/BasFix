package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SportsHall {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sportsHallId;
	
	@Column(unique=true, nullable = false)
	private String sportsHallName;

	public SportsHall() {
		super();
	}

	public SportsHall(int sportsHallId, String sportsHallName) {
		super();
		this.sportsHallId = sportsHallId;
		this.sportsHallName = sportsHallName;
	}

	public int getSportsHallId() {
		return sportsHallId;
	}

	public void setSportsHallId(int sportsHallId) {
		this.sportsHallId = sportsHallId;
	}

	public String getSportsHallName() {
		return sportsHallName;
	}

	public void setSportsHallName(String sportsHallName) {
		this.sportsHallName = sportsHallName;
	}

	@Override
	public String toString() {
		return "SportsHallDao [sportsHallId=" + sportsHallId + ", sportsHallName=" + sportsHallName + "]";
	}
}
