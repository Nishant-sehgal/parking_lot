package com.gojek.parking.lot.command;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parking.lot.exception.ParkingLotException;

public class ParkingCommandManagerTest {

	@Test
	public void testInstance() {
		ParkingCommandManager instance1 = ParkingCommandManager.getInstance();
		ParkingCommandManager instance2 = ParkingCommandManager.getInstance();
		Assert.assertNotNull(instance1);
		Assert.assertNotNull(instance2);
		Assert.assertEquals(instance1, instance2);
	}
	
	@Test(expected=ParkingLotException.class)	
	public void getCommandTestEmpty(){
		ParkingCommandManager.getInstance().getCommand("");
	}
	@Test(expected=ParkingLotException.class)	
	public void getCommandTestNull(){
		ParkingCommandManager.getInstance().getCommand(null);
	}
	@Test	
	public void getCommandCreateParkingLot(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("create_parking_lot");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof CreateParkingLotCommand, true);
	}
	@Test	
	public void getCommandForPark(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("park");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof ParkVehicleCommand, true);
	}
	@Test	
	public void getCommandforLeave(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("leave");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof UnParkVehicleCommand, true);
	}
	@Test	
	public void getCommandForStatus(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("status");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof ParkingStatusCommand, true);
	}
	@Test	
	public void getCommandRegnNoviaColor(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("registration_numbers_for_cars_with_colour");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof RegistrationDetailsViaColorCommand, true);
	}
	@Test	
	public void getCommandSlotNoViaColor(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("slot_numbers_for_cars_with_colour");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof SlotDetailsViaColorCommand, true);
	}
	@Test	
	public void getCommandSlotDetailsViaRegnNo(){
		ICommand command = ParkingCommandManager.getInstance().getCommand("slot_number_for_registration_number");
		Assert.assertNotNull(command);
		Assert.assertEquals(command instanceof SlotDetailsViaRegistrationNumberCommand, true);
	}
	
}
