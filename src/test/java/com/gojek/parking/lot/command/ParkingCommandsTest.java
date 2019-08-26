package com.gojek.parking.lot.command;

import static com.gojek.parking.lot.command.ParkingCommands.SLOT_NUMBERS_FOR_COLOR;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parking.lot.exception.ParkingLotException;

public class ParkingCommandsTest {

	@Test(expected = ParkingLotException.class)
	public void testmapToNullCommand() {
		ParkingCommands.mapToComamnd(null);
	}
	@Test(expected = ParkingLotException.class)
	public void testmapToEmptyCommand() {
		ParkingCommands.mapToComamnd("");
	}
	@Test
	public void testmapToCommand() {
		Assert.assertEquals(ParkingCommands.mapToComamnd("slot_numbers_for_cars_with_colour"),SLOT_NUMBERS_FOR_COLOR);
	}
}
