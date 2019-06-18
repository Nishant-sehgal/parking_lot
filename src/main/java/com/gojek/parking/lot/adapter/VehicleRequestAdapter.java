package com.gojek.parking.lot.adapter;

import com.gojek.parking.lot.entity.vehicle.Car;
import com.gojek.parking.lot.entity.vehicle.Vehicle;

public class VehicleRequestAdapter {

	public Vehicle buildVehicle(String[] inputCommandDetails) {
		Vehicle vehicle = null;
		if (inputCommandDetails.length == 3) {
			vehicle = new Car();
			vehicle.setColor(inputCommandDetails[2]);
			vehicle.setRegistrationNumber(inputCommandDetails[1]);
		}
		return vehicle;

	}
}
