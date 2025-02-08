package ResourcesAZ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNGAZ {
	
	public static ExtentReports getExtentReportAZ()
	{
		String path=System.getProperty("user.dir")+"//Reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Doc title");
		/*	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}*/
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "AZ project");
		
		return extent;
		
	}

}
