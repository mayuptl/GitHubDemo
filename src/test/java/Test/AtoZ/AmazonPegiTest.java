package Test.AtoZ;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import POMAZ.AmazonPegiPOM;
import TestComponentsAZ.BaseTestAZ;

public class AmazonPegiTest extends BaseTestAZ {
	
	@Test
	public void AmazonPegiTest1() throws InterruptedException, IOException
	{
		AmazonPegiPOM AmazonPegi=AmazonPegiObj();
		AmazonPegi.FindShoe("Men's Rodeo-2 Running Shoes");
		getScreenCapAZ("B");// you need to always change name here
	}

	public void getScreenCapAZ(String ScreenCapName) throws IOException
	{
		// cast your driver and create obj of TakesScreenshot class
		TakesScreenshot ss=(TakesScreenshot)driver;
		// using obj call getScreenshotAS method and store OutputType as file
		File MyScreencap=ss.getScreenshotAs(OutputType.FILE);
		// for destination address create variable
		File DestiMySreencap=new File("C:\\Users\\Teast\\Desktop\\screenCap1\\"+ScreenCapName+".png");
		// to copy that screenshot to our location
		FileUtils.copyFile(MyScreencap, DestiMySreencap);
	}
}
