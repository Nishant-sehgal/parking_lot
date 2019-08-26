package com.gojek.parking.lot.entity.vehicle;

public abstract class Vehicle {

	protected String registrationNumber;
	protected String color;
	protected VehicleSize size;

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber
	 *            the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public VehicleSize getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(VehicleSize size) {
		this.size = size;
	}

}
