package com.mbhdra.basfix.exception;

public class NoAvailableTeamsException extends Exception{
	
	public NoAvailableTeamsException() {
		super("There is no available team to add this league.");
	}
}