package Test.AtoZ;

import org.testng.annotations.Test;

import POMAZ.ActionClassPOM;
import TestComponentsAZ.BaseTestAZ;

public class ActionClassTest extends BaseTestAZ {

	@Test
	public void mouseHover()
	{
		ActionClassPOM ActionClass=ActionClassObj();
		//ActionClass.mouseHover();
		//ActionClass.keyEvent();
		//ActionClass.rightClick();
		ActionClass.DragNDrop1();
	}
	
}
