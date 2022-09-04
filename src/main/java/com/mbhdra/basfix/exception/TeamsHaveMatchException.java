package com.mbhdra.basfix.exception;

public class TeamsHaveMatchException extends Exception {
	public TeamsHaveMatchException() {
		super("At least one of the teams has another match at given date.");
	}
}