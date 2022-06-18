package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Season {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int seasonId;
	
	@Column(unique=true, nullable = false)
	private String seasonName;

	public Season() {	
		super();
	}

	public Season(String seasonName) {
		super();
		this.seasonName = seasonName;
	}

	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setseasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	@Override
	public String toString() {
		return "Season [seasonId=" + seasonId + ", seasonName=" + seasonName + "]";
	}
}
