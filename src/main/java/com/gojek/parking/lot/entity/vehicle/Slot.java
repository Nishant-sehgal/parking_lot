package com.gojek.parking.lot.entity.vehicle;

public abstract class Slot {

	private boolean isOccupied;
	protected int slotNumber;
	private Vehicle vehicle;
	public Slot(int slotNumber) {
		this.slotNumber = slotNumber;
		this.isOccupied = false;
	}
	/**
	 * @return the isOccupied
	 */
	public boolean isOccupied() {
		return isOccupied;
	}
	/**
	 * @param isOccupied the isOccupied to set
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	/**
	 * @return the slotNumber
	 */
	public int getSlotNumber() {
		return slotNumber;
	}
	/**
	 * @param slotNumber the slotNumber to set
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
