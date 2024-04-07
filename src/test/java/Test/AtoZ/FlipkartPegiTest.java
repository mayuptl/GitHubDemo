package Test.AtoZ;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import POMAZ.FlipkartPegiPOM;
import TestComponentsAZ.BaseTestAZ;

public class FlipkartPegiTest extends BaseTestAZ {
	ExtentReports extent;
	@Test(dataProvider="getDataF")
	public void FlipkartPegiTest1(String Mname) throws InterruptedException, IOException
	{
	//	config();
	//	extent.createTest("FlipkartTest");
		FlipkartPegiPOM	FlipkartPegi=FlipkartPegiObj();
		FlipkartPegi.FindMayMobile(Mname);
		FlipkartPegi.getMobileInfo();
	//	SS();
	//	extent.flush();
	}
	@DataProvider
	public String[][] getDataF()
	{
		return new String [][]
				{{"POCO M4 5G (Yellow, 128 GB)"},{"vivo V27 5G (Noble Black, 256 GB)"}};
	}

	public void SS() throws IOException
	{
		// cast driver
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File Desti=new File("D:\\Work\\Automation\\New WorkSpace\\AtoZ\\Reports\\S2.png");
		FileUtils.copyFile(source, Desti);
	}
	public void config()
	{
		//Path
		String path="D:\\Work\\Automation\\New WorkSpace\\AtoZ\\Reports\\R2.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Doc Title");
		reporter.config().setReportName("Report Name");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TesterName", "Patil");
	}
}
