package com.gojek.parking.lot.exception;

public @FunctionalInterface interface ParkingLotGenericException<E extends RuntimeException> {
	void call() throws E;
}

