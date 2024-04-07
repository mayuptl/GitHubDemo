package POMAZ;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchTabPOM {

	WebDriver driver;
	public SwitchTabPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#opentab")
	WebElement opentab;
	@FindBy(css=".support.float-left :nth-child(2) span")
	WebElement ChildTabEmail;
	public void TabSwitch()
	{
		opentab.click();
		Set<String>WT=driver.getWindowHandles();
		Iterator<String> it=WT.iterator();
		String parentTab=it.next();
		String childTab=it.next();
		
		driver.switchTo().window(childTab);
		System.out.println(ChildTabEmail.getText());
		
		driver.switchTo().window(parentTab);
		System.out.println(opentab.getText());
	}
}
