package com.gojek.parking.lot.command;

import java.util.List;

import com.gojek.parking.lot.entity.vehicle.Vehicle;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class SlotNumbersViaColorCommand implements ICommand {

	@Override
	public void execute(String[] inputCommandDetails) {
		String color = inputCommandDetails[1];
		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			List<Vehicle> vehicles = parkingManager.getVehicleDetailsViaColor(color);
			StringBuilder details = new StringBuilder();
			for (int i = 0; i < vehicles.size(); i++) {
				details.append(vehicles.get(i).getRegistrationNumber());
				if (i != vehicles.size() - 1) {
					details.append(vehicles.get(i).getRegistrationNumber()).append(", ");
				}
			}
			writer.write(details.toString());
			writer.write("");
		} catch (ParkingLotException e) {
			writer.write(String.format(e.getError().getMsg(), color));
		}

	}

}
