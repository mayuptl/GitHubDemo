package TestComponentsAZ;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import POMAZ.ActionClassPOM;
import POMAZ.AmazonPegiPOM;
import POMAZ.CheckBoxPOM;
import POMAZ.DropDownPOM;
import POMAZ.DynamicTablePOM;
import POMAZ.FlipkartPegiPOM;
import POMAZ.PaginationPOM;
import POMAZ.RadioButton;
import POMAZ.ShadowDomPOM;
import POMAZ.Suggession;
import POMAZ.SwitchTabPOM;
import POMAZ.SwitchToAlertPOM;
import POMAZ.SwitchWindowPOM;

public class BaseTestAZ {
	public WebDriver driver;
	public WebDriver driverInitialization() throws IOException
	{
		Properties prop=new Properties();
		
		FileInputStream fis1=new FileInputStream("D:\\Work\\Automation\\New WorkSpace\\AtoZ\\src\\main\\java\\ResourcesAZ\\GlobalData.properties");
		prop.load(fis1);
		
		String BrowserName=prop.getProperty("browser");
		//System.out.println(BrowserName);
		if(BrowserName.contains("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BrowserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(BrowserName.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod
	public void Start() throws IOException
	{
		driver=driverInitialization();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	public String getScreenshot(String TestCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot	ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File Destination=new File(System.getProperty("user.dir")+"//Reports"+TestCaseName+".png");
		FileUtils.copyFile(source, Destination);
		return System.getProperty("user.dir")+"//Reports"+TestCaseName+".png";
	}
	
	public RadioButton RadioButtonObj()
	{
		RadioButton RadioButton=new RadioButton(driver);
		return RadioButton;
		
	}
	
	public Suggession SuggessionObj()
	{
		Suggession Suggession=new Suggession(driver);
		return Suggession;
	}
	
	public DropDownPOM DropDownObj()
	{
		DropDownPOM DropDown=new DropDownPOM(driver);
		return DropDown;
	} 
	public CheckBoxPOM CheckBoxObj()
	{
		CheckBoxPOM CheckBox=new CheckBoxPOM(driver);
		return CheckBox;
	} 
	public SwitchWindowPOM SwitchWindowObj()
	{
		SwitchWindowPOM SwitchWindow=new SwitchWindowPOM(driver);
		return SwitchWindow;
	}
	public SwitchTabPOM SwitchTabObj()
	{
		SwitchTabPOM SwitchTab=new SwitchTabPOM(driver);
		return SwitchTab;
	}
	public SwitchToAlertPOM SwitchToAlertObj()
	{
		SwitchToAlertPOM SwitchToAlert=new SwitchToAlertPOM(driver);
		return SwitchToAlert;
	}
	public ActionClassPOM ActionClassObj()
	{
		ActionClassPOM	ActionClass=new ActionClassPOM(driver);
		return ActionClass;
	}
	public DynamicTablePOM DynamicTableObj()
	{
		DynamicTablePOM DynamicTable=new DynamicTablePOM(driver);
		return DynamicTable;
	}
	public ShadowDomPOM ShadowDomObj()
	{
		ShadowDomPOM ShadowDom=new ShadowDomPOM(driver);
		return ShadowDom;
	}
	public PaginationPOM PaginationObj()
	{
		PaginationPOM Pagination=new PaginationPOM(driver);
		return Pagination;
	}
	public FlipkartPegiPOM FlipkartPegiObj()
	{
		FlipkartPegiPOM FlipkartPegi=new FlipkartPegiPOM(driver);
		return FlipkartPegi;
	}
	public AmazonPegiPOM AmazonPegiObj()
	{
		AmazonPegiPOM AmazonPegi=new AmazonPegiPOM(driver);
		return AmazonPegi;
		
	}
}
