package com.mbhdra.basfix.exception;

public class InvalidSeasonException extends Exception {
	public InvalidSeasonException() {  
        super("Ending year must be bigger than starting year and the difference between them must be 1. Please enter appropriate years.");
    } 
}