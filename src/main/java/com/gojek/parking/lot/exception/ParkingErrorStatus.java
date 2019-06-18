package com.gojek.parking.lot.exception;

public enum ParkingErrorStatus {

	INVALID_INPUT_COMMAND("P1001", "invalid input command", "Invalid input command"),
	INVALID_INPUT_PARKING_LOT("P1002", "Cannot create parking lot", "Invalid number of parking lot"),
	NOT_IMPLEMENTED("P1003", "Not Implemented Exception", "No Implementation founs");

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
