package com.gojek.parking.lot.invoker;

import org.junit.Assert;
import org.junit.Test;

public class ParkingInvokerFactoryTest {

	@Test
	public void testInstance() {
		ParkingInvokerFactory instance1 = ParkingInvokerFactory.getInstance();
		ParkingInvokerFactory instance2 = ParkingInvokerFactory.getInstance();
		Assert.assertNotNull(instance1);
		Assert.assertNotNull(instance2);
		Assert.assertEquals(instance1, instance2);
	}

	@Test
	public void testCommandLineInvoker() {
		ParkingInvoker invoker = ParkingInvokerFactory.getInstance().getInvoker(null);	
		Assert.assertNotNull(invoker);
		Assert.assertEquals(invoker instanceof CommandLineInvoker, true);
	}

	@Test
	public void testFileInvoker() {
		ParkingInvoker invoker = ParkingInvokerFactory.getInstance().getInvoker(new String[] { "/a/b/c" });
		Assert.assertNotNull(invoker);
		Assert.assertEquals(invoker instanceof FileInvoker, true);
	}
}
