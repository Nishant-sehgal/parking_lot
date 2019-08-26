package com.gojek.parking.lot.command;

import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.lot.exception.ParkingLotException;

public class ParkVehicleCommandTest {

	private ICommand command = null;
	@Before
	public void setup(){
		new CreateParkingLotCommand().execute(new String[]{"create_parking_lot","1"});
		command = new ParkVehicleCommand();
	}
	
	@Test(expected=ParkingLotException.class)
	public void test(){
		command.execute(null);	
	}
	@Test(expected=ParkingLotException.class)
	public void testCreateZeroSize(){
		command.execute(new String[]{});
	}
	@Test(expected=ParkingLotException.class)
	public void testCreateSizeLessThan3(){		
		command.execute(new String[]{"park","KA-01-P-333"});
	}
	@Test
	public void testCreate(){
		command.execute(new String[]{"park","KA-01-P-333","White"});
	}
}
