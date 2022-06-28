package com.mbhdra.basfix.exception;

public class SameTeamException extends Exception {
	public SameTeamException() {
		super("Two teams cannot be same in a match. Choose different teams.");
	}

}
