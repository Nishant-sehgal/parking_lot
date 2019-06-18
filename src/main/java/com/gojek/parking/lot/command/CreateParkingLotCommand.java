package com.gojek.parking.lot.command;

import com.gojek.parking.Writer.Writer;
import com.gojek.parking.Writer.WriterFactory;
import com.gojek.parking.Writer.WriterType;
import com.gojek.parking.lot.manager.IParkingManager;
import com.gojek.parking.lot.manager.ParkingManager;

public class CreateParkingLotCommand implements ICommand{

	public void execute(String[] inputCommandDetails) {
		Integer size = Integer.valueOf(inputCommandDetails[1]);
		IParkingManager parkingManager = ParkingManager.getInstance();
		parkingManager.createParkingSlots(size);
		Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
		writer.write("");
	}

}
