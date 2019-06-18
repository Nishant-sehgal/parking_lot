package com.gojek.parking.lot.command;

import java.util.List;

import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class SlotDetailsViaColorCommand implements ICommand {

	@Override
	public void execute(String[] inputCommandDetails) {
		String color = inputCommandDetails[1];
		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			List<Slot> slots = parkingManager.getSlotDetailsViaColor(color);
			StringBuilder details = new StringBuilder();
			for (int i = 0; i < slots.size(); i++) {
				details.append(slots.get(i).getSlotNumber());
				if (i != slots.size() - 1) {
					details.append(", ");
				}
			}
			writer.write(details.toString());			
		} catch (ParkingLotException e) {
			writer.write(String.format(e.getError().getMsg(), color));
		}

	}

}
