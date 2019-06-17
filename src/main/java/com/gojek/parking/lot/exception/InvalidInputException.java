package com.gojek.parking.lot.exception;

public class InvalidInputException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidInputException(ParkingErrorStatus invalidInputCommand) {
		super(invalidInputCommand.getError());
	}
}
