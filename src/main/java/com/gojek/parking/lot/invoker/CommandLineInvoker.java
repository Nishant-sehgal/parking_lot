package com.gojek.parking.lot.invoker;

import static com.gojek.parking.lot.constant.ParkingConstants.EXIT;

import java.util.Scanner;

import com.gojek.parking.lot.command.ParkingCommandManager;
import com.gojek.parking.lot.constant.ParkingConstants;

public class CommandLineInvoker implements ParkingInvoker {

	@Override
	public void invoke() {
		Scanner in = new Scanner(System.in);
		String inputCommand = in.nextLine();		
		while (!EXIT.equalsIgnoreCase(inputCommand)) {
			String[] inputCommandDetails = inputCommand.split(ParkingConstants.SPACE);
			ParkingCommandManager.getInstance().getCommand(inputCommandDetails[0]).execute(inputCommandDetails);
			inputCommand = in.nextLine();
		}
		in.close();
	}

}
