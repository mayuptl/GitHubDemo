package POMAZ;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchWindowPOM {

	WebDriver driver;
	public SwitchWindowPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#openwindow")
	WebElement windowBtn;
	
	public void SwitchWindow()
	{
		windowBtn.click();
		WindowHand();
		
	}
	/*	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}*/
	public void WindowHand()
	{
		Set<String> WH=driver.getWindowHandles();
		Iterator<String> it=WH.iterator();
		// if we want to switch to peticular window then first we need to store each window then iterate
		String firstWindow=it.next();
		String secondWindow=it.next();
		//then iterate
		driver.switchTo().window(secondWindow);
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		//then iterate
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getCurrentUrl());
		
		
	// if we want to perform same action on each window/need to iterate to each window	
	/*	while (it.hasNext()) 
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getCurrentUrl());
		} */
	}
}
