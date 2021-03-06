package com.gojek.parking.lot.command;

import static com.gojek.parking.lot.exception.ParkingErrorStatus.INVALID_INPUT_COMMAND;

import com.gojek.parking.lot.adapter.VehicleRequestAdapter;
import com.gojek.parking.lot.constant.Messages;
import com.gojek.parking.lot.entity.vehicle.Slot;
import com.gojek.parking.lot.entity.vehicle.Vehicle;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.VerifyException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class ParkVehicleCommand implements ICommand {

	public void execute(String[] inputCommandDetails) {
		VerifyException.verifyInput(
				null == inputCommandDetails || inputCommandDetails.length == 0 || inputCommandDetails.length != 3,
				() -> {
					throw new ParkingLotException(INVALID_INPUT_COMMAND);
				});
		VehicleRequestAdapter vehicleRequestAdapter = new VehicleRequestAdapter();
		Vehicle vehicle = vehicleRequestAdapter.buildVehicle(inputCommandDetails);
		IParkingManager parkingManager = ParkingManager.getInstance();
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		try {
			Slot slot = parkingManager.park(vehicle);
			writer.write(String.format(Messages.SLOT_ALLOCATED_MSG, slot.getSlotNumber()));
		} catch (ParkingLotException e) {
			writer.write(e.getError().getMsg());
		}
	}

}
