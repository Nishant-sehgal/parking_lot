package com.gojek.parking.lot.manager;

import java.util.List;

import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.entity.vehicle.Vehicle;

public interface IParkingManager {

	Integer createParkingSlots(Integer slotSize);
	Slot park(Vehicle vehicle);
	Slot unpark(Integer slotNumber);
	List<Slot> status();
	List<Vehicle> getVehicleDetailsViaColor(String color);
	List<Slot> getSlotDetailsViaColor(String color);
	Slot getSlotNoForGivenVehicle(String registrationNumber);
}
