package com.gojek.parking.lot.invoker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.gojek.parking.lot.command.ParkingCommandManager;
import com.gojek.parking.lot.constant.ParkingConstants;

public class FileInvoker implements ParkingInvoker {

	private String path = null;

	public FileInvoker(String path) {
		this.path = path;
	}

	@Override
	public void invoke() {
		File file = new File(this.path);
		try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader);) {
			String inputCommand = reader.readLine();
			while (null != inputCommand) {
				String[] inputCommandDetails = inputCommand.split(ParkingConstants.SPACE);
				ParkingCommandManager.getInstance().getCommand(inputCommandDetails[0]).execute(inputCommandDetails);
				inputCommand = reader.readLine();
			}
		} catch (IOException e) {

		}

	}
}
