// Entity that represents the intermediate table between team and league entities

package com.mbhdra.basfix.model;

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
public class TeamLeague {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamLeagueId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "team_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Team team;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "league_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private League league;

	public TeamLeague() {
		super();
	}

	public TeamLeague(int teamLeagueId, Team team, League league) {
		super();
		this.teamLeagueId = teamLeagueId;
		this.team = team;
		this.league = league;
	}

	public int getTeamLeagueId() {
		return teamLeagueId;
	}

	public void setTeamLeagueId(int teamLeagueId) {
		this.teamLeagueId = teamLeagueId;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	@Override
	public String toString() {
		return "TeamLeague [teamLeagueId=" + teamLeagueId + ", team=" + team + ", league=" + league + "]";
	}
}
