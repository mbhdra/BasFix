package com.mbhdra.basfix.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SystemUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column(unique=true, nullable = false)
	private String uname;
	
	@Column(nullable = false)
	private String upass;
	
	@Column(nullable = false)
	private String urole;
	
	public SystemUser() {
		
		super();
		
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
	
	public String getUrole() {
		
		return urole;
		
	}
	
	public void setUrole(String urole) {
		
		this.urole = urole;
		
	}
	
	@Override
	public String toString() {
		
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", urole=" + urole + "]";
		
	}
}
