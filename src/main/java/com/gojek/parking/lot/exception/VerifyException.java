package com.gojek.parking.lot.exception;

public class VerifyException {

	private VerifyException() {
	}
	
	public static <E extends RuntimeException> void verifyInput(boolean expression, ParkingLotGenericException<E> function) throws E {
		if (expression) {
			function.call();
		}
	}
}
