package com.gojek.parking.lot.invoker;

import com.gojek.parking.lot.exception.ParkingErrorStatus;
import com.gojek.parking.lot.exception.ParkingLotException;

public interface ParkingInvoker {

	default void invoke() {
		throw new ParkingLotException(ParkingErrorStatus.NOT_IMPLEMENTED);
	}
}
