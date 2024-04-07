package Test.AtoZ;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import POMAZ.DynamicTablePOM;
import TestComponentsAZ.BaseTestAZ;

public class DynamicTableTest extends BaseTestAZ {
	ExtentReports extent;
	public void config()
	{
		//Path
		String path="D:\\Work\\Automation\\New WorkSpace\\AtoZ\\Reports\\R.html";
																//"C:\\Users\\Teast\\Desktop\\screenCap1\\index.html";
		//ExtentSparkReporter
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		// To set the report name and doc title
		reporter.config().setReportName("Dynamic Table");
		reporter.config().setDocumentTitle("Dyanmic table result");
		// create extent report obj
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "ayur");
	}
	
	@Test
	public void DT()
	{
		config();
		extent.createTest("DynamicTableTest");
		DynamicTablePOM DynamicTable=DynamicTableObj();
		String[] valuesFrompom=DynamicTable.findOut2();
		String ActualText=valuesFrompom[0];
		String ExpectedText=valuesFrompom[1];
		System.out.println(ActualText);
		Assert.assertEquals(ActualText,"Chrome CPU: "+ExpectedText);
		extent.flush();
	}
}
