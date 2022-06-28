package com.mbhdra.basfix.model;

import java.sql.Date;
import java.sql.Time;

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
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int matchId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ateam_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Team aTeam;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bteam_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Team bTeam;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "sports_hall_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private SportsHall sportsHall;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "league_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private League league;
	
	@Column(nullable = false)
	private Date date;
	
	@Column(nullable = false)
	private Time time;

	public Match() {
		super();
	}

	public Match(int matchId, Team aTeam, Team bTeam, SportsHall sportsHall, League league, Date date, Time time) {
		super();
		this.matchId = matchId;
		this.aTeam = aTeam;
		this.bTeam = bTeam;
		this.sportsHall = sportsHall;
		this.league = league;
		this.date = date;
		this.time = time;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Team getaTeam() {
		return aTeam;
	}

	public void setaTeam(Team aTeam) {
		this.aTeam = aTeam;
	}

	public Team getbTeam() {
		return bTeam;
	}

	public void setbTeam(Team bTeam) {
		this.bTeam = bTeam;
	}

	public SportsHall getSportsHall() {
		return sportsHall;
	}
	
	public void setSportsHall(SportsHall sportsHall) {
		this.sportsHall = sportsHall;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	public League getLeague() {
		return league;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", aTeam=" + aTeam + ", bTeam=" + bTeam + ", sportsHall=" + sportsHall
				+ ", date=" + date + ", time=" + time + "]";
	}
}
