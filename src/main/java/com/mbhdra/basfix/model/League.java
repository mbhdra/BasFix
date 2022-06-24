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
import org.springframework.stereotype.Component;

@Entity
@Component
public class League {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int leagueId;
	
	@Column(unique = true, nullable = false)
	private String leagueName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "season_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Season season;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "division_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Division division;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "gender_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Gender gender;

	public League() {
		super();
	}

	public League(int leagueId, String leagueName, Season season, Division division, Gender gender) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.season = season;
		this.division = division;
		this.gender = gender;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
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
		return "League [leagueId=" + leagueId + ", leagueName=" + leagueName + ", season=" + season + ", division="
				+ division + ", gender=" + gender + "]";
	}
}
