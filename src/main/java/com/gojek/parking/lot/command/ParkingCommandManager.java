package com.gojek.parking.lot.command;

import java.util.EnumMap;
import java.util.Map;

public class ParkingCommandManager {	

	private static Map<ParkingCommands, ICommand> commandMap = new EnumMap<>(ParkingCommands.class);
	
	private static final ParkingCommandManager INSTANCE = new ParkingCommandManager();

	private ParkingCommandManager() {
		commandMap.put(ParkingCommands.CREATE_PARKING_LOT, new CreateParkingLotCommand());
		commandMap.put(ParkingCommands.PARK, new ParkVehicleCommand());
		commandMap.put(ParkingCommands.LEAVE, new UnParkVehicleCommand());
		commandMap.put(ParkingCommands.REGISTRATION_NUMBERS_FOR_COLOR, new RegistrationDetailsViaColorCommand());
		commandMap.put(ParkingCommands.SLOT_NUMBERS_FOR_COLOR, new SlotDetailsViaColorCommand());
		commandMap.put(ParkingCommands.STATUS, new ParkingStatusCommand());
		commandMap.put(ParkingCommands.SLOT_NUMBER_FOR_REGISTRATION, new SlotDetailsViaRegistrationNumberCommand());
	}

	public static ParkingCommandManager getInstance() {
		return INSTANCE;
	}

	public ICommand getCommand(String inputCommand) {
		return commandMap.get(ParkingCommands.mapToComamnd(inputCommand));
	}
}
