package driverFactory;

import org.testng.annotations.Test;

public class AppTest {

		@Test
		public void kickStart() throws Throwable
		{
			DriversScript ds = new DriversScript();
			ds.startTest();
		}
}
