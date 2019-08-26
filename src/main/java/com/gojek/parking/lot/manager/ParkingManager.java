package com.gojek.parking.lot.manager;

import static com.gojek.parking.lot.exception.ParkingErrorStatus.INVALID_INPUT_SLOT_NUMBER;
import static com.gojek.parking.lot.exception.ParkingErrorStatus.NO_PARKING_SLOT_ALLOCATED;
import static com.gojek.parking.lot.exception.ParkingErrorStatus.NO_SLOT_ALLOCATION;
import static com.gojek.parking.lot.exception.ParkingErrorStatus.NO_SLOT_FOUND;
import static com.gojek.parking.lot.exception.ParkingErrorStatus.PARKING_LOT_FULL;

import java.util.ArrayList;
import java.util.List;

import com.gojek.parking.lot.entity.vehicle.ParkingSlot;
import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.entity.vehicle.Vehicle;
import com.gojek.parking.lot.exception.ParkingErrorStatus;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.VerifyException;

public class ParkingManager implements IParkingManager {

	private static final ParkingManager INSTANCE = new ParkingManager();

	public static ParkingManager getInstance() {
		return INSTANCE;
	}

	@Override
	public Integer createParkingSlots(Integer slotSize) {
		return ParkingSlot.getInstance().createParkingSlots(slotSize);
	}

	@Override
	public Slot park(Vehicle vehicle) {
		List<Slot> parkingSlots = getParkingSlot();

		Slot availableSlot = null;
		for (Slot slot : parkingSlots) {
			if (!slot.isOccupied()) {
				assignSlot(slot, vehicle);
				availableSlot = slot;
				break;
			}
		}

		VerifyException.verifyInput(null == availableSlot, () -> {
			throw new ParkingLotException(PARKING_LOT_FULL);
		});

		return availableSlot;
	}

	private void assignSlot(Slot slot, Vehicle vehicle) {
		slot.setOccupied(true);
		slot.setVehicle(vehicle);
	}

	@Override
	public Slot unpark(Integer slotNumber) {
		List<Slot> parkingSlots = getParkingSlot();
		VerifyException.verifyInput(null == parkingSlots || parkingSlots.isEmpty(), () -> {
			throw new ParkingLotException(INVALID_INPUT_SLOT_NUMBER);
		});
		Slot unparkSlot = null;
		for (Slot slot : parkingSlots) {
			if (slot.getSlotNumber() == slotNumber) {
				slot.setOccupied(false);
				slot.setVehicle(null);
				unparkSlot = slot;
				break;
			}
		}
		VerifyException.verifyInput(null == parkingSlots || parkingSlots.isEmpty(), () -> {
			throw new ParkingLotException(NO_SLOT_FOUND);
		});

		return unparkSlot;
	}

	@Override
	public List<Slot> status() {
		List<Slot> parkingSlots = getParkingSlot();
		List<Slot> allocatedSlotList = new ArrayList<>();
		for (Slot slot : parkingSlots) {
			if (slot.isOccupied()) {
				allocatedSlotList.add(slot);
			}
		}

		VerifyException.verifyInput(null == parkingSlots || parkingSlots.isEmpty(), () -> {
			throw new ParkingLotException(NO_SLOT_ALLOCATION);
		});

		return allocatedSlotList;
	}

	@Override
	public List<Vehicle> getVehicleDetailsViaColor(String color) {
		List<Slot> parkingSlots = getParkingSlot();
		List<Vehicle> vehicleList = new ArrayList<>();
		for (Slot slot : parkingSlots) {
			if (slot.isOccupied() && slot.getVehicle().getColor().equalsIgnoreCase(color)) {
				vehicleList.add(slot.getVehicle());
			}
		}
		VerifyException.verifyInput(vehicleList.isEmpty(), () -> {
			throw new ParkingLotException(ParkingErrorStatus.NO_VEHICLE_AVAILABLE_FOR_COLOR);
		});

		return vehicleList;
	}

	@Override
	public List<Slot> getSlotDetailsViaColor(String color) {
		List<Slot> parkingSlots = getParkingSlot();
		List<Slot> slotList = new ArrayList<>();
		for (Slot slot : parkingSlots) {
			if (slot.isOccupied() && slot.getVehicle().getColor().equalsIgnoreCase(color)) {
				slotList.add(slot);
			}
		}
		VerifyException.verifyInput(slotList.isEmpty(), () -> {
			throw new ParkingLotException(ParkingErrorStatus.NO_SLOT_AVAILABLE_FOR_COLOR);
		});

		return slotList;
	}

	@Override
	public Slot getSlotNoForGivenVehicle(String registrationNumber) {
		List<Slot> parkingSlots = getParkingSlot();
		Slot foundSlot = null;
		for (Slot slot : parkingSlots) {
			if (slot.isOccupied() && slot.getVehicle().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
				foundSlot = slot;
				break;
			}
		}
		VerifyException.verifyInput(null == foundSlot, () -> {
			throw new ParkingLotException(ParkingErrorStatus.NO_SLOT_FOUND);
		});

		return foundSlot;

	}

	private List<Slot> getParkingSlot() {
		List<Slot> parkingSlots = ParkingSlot.getInstance().getParkingSlots();
		VerifyException.verifyInput(null == parkingSlots || parkingSlots.isEmpty(), () -> {
			throw new ParkingLotException(NO_PARKING_SLOT_ALLOCATED);
		});
		return parkingSlots;
	}

}
