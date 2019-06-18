package com.gojek.parking.lot.manager;

import com.gojek.parking.lot.entity.vehicle.ParkingSlot;

public class ParkingManager implements IParkingManager {

	private static final ParkingManager INSTANCE = new ParkingManager();

	public static ParkingManager getInstance() {
		return INSTANCE;
	}

	@Override
	public Integer createParkingSlots(Integer slotSize) {
		return ParkingSlot.getInstance().createParkingSlots(slotSize);
	}

}
