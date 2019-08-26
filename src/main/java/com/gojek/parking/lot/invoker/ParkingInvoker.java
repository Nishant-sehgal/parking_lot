package com.gojek.parking.lot.invoker;

import com.gojek.parking.lot.exception.ParkingErrorStatus;
import com.gojek.parking.lot.exception.ParkingLotGeneralException;

public interface ParkingInvoker {

	default void invoke() {
		throw new ParkingLotGeneralException(ParkingErrorStatus.NOT_IMPLEMENTED);
	}
}
