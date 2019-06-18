package com.gojek.parking.lot.command;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.gojek.parking.lot.exception.ParkingLotException;
import com.gojek.parking.lot.exception.ParkingErrorStatus;
import com.gojek.parking.lot.exception.VerifyException;

public enum ParkingCommands {

	CREATE_PARKING_LOT("create_parking_lot"), PARK("park"), LEAVE("leave"), STATUS(
			"status"), REGISTRATION_NUMBERS_FOR_COLOR(
					"registration_numbers_for_cars_with_colour"), SLOT_NUMBERS_FOR_COLOR(
							"slot_numbers_for_cars_with_colour"), SLOT_NUMBER_FOR_REGISTRATION(
									"slot_number_for_registration_number");

	private static Map<String, ParkingCommands> parkingCommandMap = Collections
			.unmodifiableMap(initializeErrorMapping());

	private String commandName;

	ParkingCommands(String command) {
		this.commandName = command;
	}

	public static ParkingCommands mapToComamnd(String inputCommand) {
		ParkingCommands command = parkingCommandMap.get(inputCommand) != null ? parkingCommandMap.get(inputCommand) : null;
		VerifyException.verifyInput(null == command, () -> {
			throw new ParkingLotException(ParkingErrorStatus.INVALID_INPUT_COMMAND);
		});
		return command;
	}

	private static Map<String, ParkingCommands> initializeErrorMapping() {
		Map<String, ParkingCommands> errorMappingMap = new HashMap<>();
		for (ParkingCommands command : ParkingCommands.values()) {
			errorMappingMap.put(command.name(), command);
		}
		return errorMappingMap;
	}

	/**
	 * @return the commandName
	 */
	public String getCommandName() {
		return commandName;
	}

}
