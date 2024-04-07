package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.DropDownPOM;
import TestComponentsAZ.BaseTestAZ;

public class DropDownTest extends BaseTestAZ {

	@Test
	public void DropDownTest1()
	{
		DropDownPOM DropDown=DropDownObj();
		DropDown.selectDropDown();
	}
}
