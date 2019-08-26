package com.gojek.parking.lot.invoker;

public class ParkingInvokerFactory {

	private static final ParkingInvokerFactory INSTANCE = new ParkingInvokerFactory();

	private ParkingInvokerFactory() {
	}

	public static ParkingInvokerFactory getInstance() {
		return INSTANCE;
	}

	public ParkingInvoker getInvoker(String[] args) {
		if (null != args && args.length > 0) {
			return new FileInvoker(args[0]);
		}
		return new CommandLineInvoker();
	}
}
