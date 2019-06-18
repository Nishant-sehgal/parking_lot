package com.gojek.parking.lot.exception;

public enum ParkingErrorStatus {

	INVALID_INPUT_COMMAND("P1001", "invalid input command", "Invalid input command"),
	INVALID_INPUT_PARKING_LOT("P1002", "Cannot create parking lot", "Invalid number of parking lot"),
	NOT_IMPLEMENTED("P1003", "Not Implemented Exception", "No Implementation found"),
	NO_PARKING_SLOT_ALLOCATED("P1004", "No Parking Slot allocation done", "No parking slots"),
	PARKING_LOT_FULL("P1005","Sorry, parking lot is full","no slot available"),
	INVALID_INPUT_SLOT_NUMBER("P1006","input slot number in null or empty","input slot number is empty"),
	NO_SLOT_FOUND("P1007","Not found","no slot found"),
	NO_SLOT_ALLOCATION("P1008","No Slot Allocated","all slots are free no allocation done."),
    NO_VEHICLE_AVAILABLE_FOR_COLOR("P1009","No Vehicle Available With color %s","No vehicle available for given color."),
	NO_SLOT_AVAILABLE_FOR_COLOR("P1010","No Slot Allocated With color %s","No Slot available for given color."); 

	private String code;
	private String msg;
	private String description;

	private ParkingErrorStatus(String code, String msg, String desc) {
		this.code = code;
		this.msg = msg;
		this.description = desc;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
