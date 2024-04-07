package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.SwitchToAlertPOM;
import TestComponentsAZ.BaseTestAZ;

public class AlertTest extends BaseTestAZ {

	@Test
	public void AlertTest1()
	{
		SwitchToAlertPOM SwitchToAlert=SwitchToAlertObj();
		SwitchToAlert.GenrateAlert();
	}
}
