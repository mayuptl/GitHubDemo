package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.SwitchTabPOM;
import TestComponentsAZ.BaseTestAZ;

public class SwitchTabTest extends BaseTestAZ {
	
	@Test
	public void SwitchTabTest1()
	{
		SwitchTabPOM SwitchTab=SwitchTabObj();
		SwitchTab.TabSwitch();
	}
	
}
