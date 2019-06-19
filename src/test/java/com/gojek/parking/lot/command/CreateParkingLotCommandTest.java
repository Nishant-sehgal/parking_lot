package com.gojek.parking.lot.command;

import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.lot.exception.ParkingLotException;

public class CreateParkingLotCommandTest {

	private ICommand command = null;
	@Before
	public void setup(){
		command = new CreateParkingLotCommand();
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
	public void testCreateSizeGreaterThan1(){
		command.execute(new String[]{"create_parking_lot","1","2"});
	}
	@Test
	public void testCreate(){
		command.execute(new String[]{"create_parking_lot","6"});
	}
}
