package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clubId;
	
	@Column(unique = true, nullable = false)
	private String clubName;
	
	public Club() {
		super();
	}

	public Club(int clubId, String clubName) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + "]";
	}
}