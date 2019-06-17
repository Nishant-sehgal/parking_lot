package com.gojek.parking.lot.exception;

public enum ParkingErrorStatus {

	INVALID_INPUT_COMMAND("invalid input command");
	
	private String error;
	
	private ParkingErrorStatus(String error){
		this.error = error;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	
}
