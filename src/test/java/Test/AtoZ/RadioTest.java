package Test.AtoZ;


import org.testng.annotations.Test;

import POMAZ.RadioButton;
import TestComponentsAZ.BaseTestAZ;

public class RadioTest extends BaseTestAZ {

	@Test
	public void test()
	{
		RadioButton RadioButton=RadioButtonObj();
		RadioButton.RdBtn1();
	}
}
