package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamId;
	
	@Column(unique = true, nullable = false)
	private String teamName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "club_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Club club;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "division_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Division division;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gender_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Gender gender;

	public Team() {
		super();
	}

	public Team(int teamId, String teamName, Club club, Division division, Gender gender) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.club = club;
		this.division = division;
		this.gender = gender;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", club=" + club + ", division=" + division
				+ ", gender=" + gender + "]";
	}
}