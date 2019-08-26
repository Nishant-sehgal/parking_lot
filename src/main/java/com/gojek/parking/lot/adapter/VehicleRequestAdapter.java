package com.gojek.parking.lot.adapter;

import static com.gojek.parking.lot.exception.ParkingErrorStatus.INVALID_INPUT_COMMAND;

import com.gojek.parking.lot.entity.vehicle.Car;
import com.gojek.parking.lot.entity.vehicle.Vehicle;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.VerifyException;

public class VehicleRequestAdapter {

	public Vehicle buildVehicle(String[] inputCommandDetails) {
		Vehicle vehicle = null;
		VerifyException.verifyInput(
				null == inputCommandDetails || inputCommandDetails.length == 0 || inputCommandDetails.length > 3,
				() -> {
					throw new ParkingLotException(INVALID_INPUT_COMMAND);
				});
		
		if (inputCommandDetails.length == 3) {
			vehicle = new Car();
			vehicle.setColor(inputCommandDetails[2]);
			vehicle.setRegistrationNumber(inputCommandDetails[1]);
		}
		return vehicle;

	}
}
