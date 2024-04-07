package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.ShadowDomPOM;
import TestComponentsAZ.BaseTestAZ;

public class ShadowDomTest extends BaseTestAZ {
	@Test
	public void ShadowDomTest1()
	{
		ShadowDomPOM ShadowDom=ShadowDomObj();
		ShadowDom.Shadow();
	}

}
