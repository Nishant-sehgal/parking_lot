package com.gojek.parking.lot.command;

import static com.gojek.parking.lot.constant.Messages.SLOT_FREE_MSG;

import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class UnParkVehicleCommand implements ICommand {

	public void execute(String[] inputCommandDetails) {
		Integer slotNumber = Integer.valueOf(inputCommandDetails[1]);
		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			Slot slot = parkingManager.unpark(slotNumber);			
			writer.write(String.format(SLOT_FREE_MSG, slot.getSlotNumber()));
		} catch (ParkingLotException e) {
			writer.write(e.getError().getMsg());
		}
	}

}
