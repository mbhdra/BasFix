package com.mbhdra.basfix.exception;

public class SameSportsHallDateTimeException extends Exception {
	public SameSportsHallDateTimeException() {
		super("A match exist in this sports hall with same date and time.");
	}
}