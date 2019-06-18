package com.gojek.parking.lot.entity.vehicle;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.ParkingErrorStatus;
import com.gojek.parking.lot.exception.VerifyException;

public class ParkingSlot {

	private static final ParkingSlot INSTANCE = new ParkingSlot();
	private List<Slot> parkingSlots;

	private ParkingSlot() {
		parkingSlots = new ArrayList<>();
	}

	public static ParkingSlot getInstance() {
		return INSTANCE;
	}

	public int createParkingSlots(int noOfSlots) {
		VerifyException.verifyInput(noOfSlots<=0, () -> {
			throw new ParkingLotException(ParkingErrorStatus.INVALID_INPUT_PARKING_LOT);
		});
		
		for (int i = 1; i <= noOfSlots; i++) {
			parkingSlots.add(new CompactSlot(i));
		}
		return parkingSlots.size();
	}
}
