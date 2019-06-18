package com.gojek.parking.lot.command;

import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class SlotDetailsViaRegistrationNumberCommand implements ICommand {

	@Override
	public void execute(String[] inputCommandDetails) {
		String registrationNUmber = inputCommandDetails[1];
		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			Slot slot = parkingManager.getSlotNoForGivenVehicle(registrationNUmber);
			writer.write(String.valueOf(slot.getSlotNumber()));
		} catch (ParkingLotException e) {
			writer.write(String.format(e.getError().getMsg(), registrationNUmber));
		}

	}

}
