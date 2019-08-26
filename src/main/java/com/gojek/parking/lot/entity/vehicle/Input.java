package com.gojek.parking.lot.entity.vehicle;

public class Input {

	private int noOfLots;
	private String parkingCommand;

	public Input(Builder builder) {
		this.noOfLots = builder.noOfSots;
		this.parkingCommand = builder.parkingCommand;
	}

	/**
	 * @return the noOfLots
	 */
	public int getNoOfLots() {
		return noOfLots;
	}

	/**
	 * @return the parkingCommand
	 */
	public String getCommand() {
		return parkingCommand;
	}

	public static class Builder {

		private int noOfSots;
		private String parkingCommand;

		public Builder setSlots(int slots) {
			this.noOfSots = slots;
			return this;
		}

		public Builder command(String command) {
			this.parkingCommand = command;
			return this;
		}

		public Input build() {
			return new Input(this);
		}
	}

}
