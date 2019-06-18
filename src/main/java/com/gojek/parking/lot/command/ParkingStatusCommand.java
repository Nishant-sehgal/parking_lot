package com.gojek.parking.lot.command;

import static com.gojek.parking.lot.constant.Messages.PARKING_CURRENT_STATUS_BODY_MSG;
import static com.gojek.parking.lot.constant.Messages.PARKING_CURRENT_STATUS_HEADER_MSG;

import java.util.List;

import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class ParkingStatusCommand implements ICommand {

	@Override
	public void execute(String[] inputCommandDetails) {

		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			List<Slot> slots = parkingManager.status();
			writer.write(PARKING_CURRENT_STATUS_HEADER_MSG);
			for (Slot pSlot : slots) {
				writer.write(String.format(PARKING_CURRENT_STATUS_BODY_MSG, pSlot.getSlotNumber(),
						pSlot.getVehicle().getRegistrationNumber(), pSlot.getVehicle().getColor()));
			}
		} catch (ParkingLotException e) {
			writer.write(e.getError().getMsg());
		}

	}

}
