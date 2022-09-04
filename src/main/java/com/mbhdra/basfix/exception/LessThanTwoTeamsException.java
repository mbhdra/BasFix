package com.mbhdra.basfix.exception;

public class LessThanTwoTeamsException extends Exception {
	public LessThanTwoTeamsException() {  
        super("The team number is less than 2 in this league. Any match cannot be created.");
    }
}