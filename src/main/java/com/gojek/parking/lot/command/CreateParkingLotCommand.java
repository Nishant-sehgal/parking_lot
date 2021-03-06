package com.gojek.parking.lot.command;

import static com.gojek.parking.lot.exception.ParkingErrorStatus.INVALID_INPUT_COMMAND;

import com.gojek.parking.lot.constant.Messages;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.VerifyException;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class CreateParkingLotCommand implements ICommand {

	public void execute(String[] inputCommandDetails) {
		VerifyException.verifyInput(
				null == inputCommandDetails || inputCommandDetails.length == 0 || inputCommandDetails.length > 2,
				() -> {
					throw new ParkingLotException(INVALID_INPUT_COMMAND);
				});
		Integer size = Integer.valueOf(inputCommandDetails[1]);
		IParkingManager parkingManager = ParkingManager.getInstance();
		int parkingLotSize = parkingManager.createParkingSlots(size);
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		writer.write(String.format(Messages.PARKING_LOT_CREATION_MSG, parkingLotSize));
	}

}
