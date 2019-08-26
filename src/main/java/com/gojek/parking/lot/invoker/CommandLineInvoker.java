package com.gojek.parking.lot.invoker;

import static com.gojek.parking.lot.constant.ParkingConstants.EXIT;

import java.util.Scanner;

import com.gojek.parking.lot.command.ParkingCommandManager;
import com.gojek.parking.lot.constant.ParkingConstants;
import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.writer.Writer;
import com.gojek.parking.writer.WriterFactory;
import com.gojek.parking.writer.WriterType;

public class CommandLineInvoker implements ParkingInvoker {

	@Override
	public void invoke() {
		Scanner in = new Scanner(System.in);
		String inputCommand = in.nextLine();
		while (!EXIT.equalsIgnoreCase(inputCommand)) {
			String[] inputCommandDetails = inputCommand.split(ParkingConstants.SPACE);
			try {
				ParkingCommandManager.getInstance().getCommand(inputCommandDetails[0]).execute(inputCommandDetails);
			} catch (ParkingLotException e) {
				Writer writer = WriterFactory.getInstance().getWriter(WriterType.CONSOLE);
				writer.write(e.getError().getMsg());
			}
			inputCommand = in.nextLine();
		}
		in.close();
	}

}
