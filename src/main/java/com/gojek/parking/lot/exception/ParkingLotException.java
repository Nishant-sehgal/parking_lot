package com.gojek.parking.lot.exception;

public class ParkingLotException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final ParkingErrorStatus error;

	public ParkingLotException(ParkingErrorStatus error) {
		super(new StringBuilder(error.getCode()).append(" ").append(error.getMsg()).append(" ")
				.append(error.getDescription()).toString());
		this.error = error;
	}

	/**
	 * @return the error
	 */
	public ParkingErrorStatus getError() {
		return error;
	}
	
}
