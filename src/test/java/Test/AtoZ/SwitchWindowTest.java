package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.SwitchWindowPOM;
import TestComponentsAZ.BaseTestAZ;

public class SwitchWindowTest extends BaseTestAZ{
	@Test
	public void SwitchWindow1()
	{
		SwitchWindowPOM SwitchWindow=SwitchWindowObj();
		SwitchWindow.SwitchWindow();
	}

}
