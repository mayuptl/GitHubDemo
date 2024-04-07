package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.CheckBoxPOM;
import TestComponentsAZ.BaseTestAZ;

public class CheckBoxTest extends BaseTestAZ {

	@Test
	public void CheckBoxText1()
	{
		CheckBoxPOM CheckBox=CheckBoxObj();
		CheckBox.checkBoxCheck("Option3");
	}
}
