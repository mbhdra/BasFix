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
public class SystemUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column(unique=true, nullable = false)
	private String uname;
	
	@Column(nullable = false)
	private String upass;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "role_id", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private UserRole urole;
	
	public SystemUser() {	
		super();
	}
	
	public SystemUser(int uid, String uname, String upass, UserRole urole) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.urole = urole;
	}

	public int getUid() {
		return uid;	
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public String getUpass() {
		return upass;
	}
	
	public void setUpass(String upass) {
		this.upass = upass;
	}
	
	public UserRole getUrole() {
		return urole;
	}
	
	public void setUrole(UserRole urole) {
		this.urole = urole;
	}
}
