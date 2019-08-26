package com.gojek.parking.app;

import com.gojek.parking.lot.invoker.ParkingInvokerFactory;

public class ParkingLotMain {

	public static void main(String[] args) {
		ParkingInvokerFactory.getInstance().getInvoker(args).invoke();
	}

}
