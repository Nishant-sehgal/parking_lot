package com.gojek.parking.lot.command;

import java.util.EnumMap;
import java.util.Map;

public class ParkingCommandManager {

	private static final ParkingCommandManager INSTANCE = new ParkingCommandManager();

	private static Map<ParkingCommands, ICommand> commandMap = new EnumMap<>(ParkingCommands.class);

	private ParkingCommandManager() {
		commandMap.put(ParkingCommands.CREATE_PARKING_LOT, new CreateParkingLotCommand());
	}

	public static ParkingCommandManager getInstance() {
		return INSTANCE;
	}

	public ICommand getCommand(String inputCommand) {
		return commandMap.get(ParkingCommands.mapToComamnd(inputCommand));
	}
}
