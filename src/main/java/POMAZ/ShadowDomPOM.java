package POMAZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShadowDomPOM {
	WebDriver driver;
	public ShadowDomPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#buttonGenerate")
	WebElement gearIcon;
	@FindBy(css="#editField")
	WebElement editValue;
	public void Shadow()
	{
		driver.get("http://uitestingplayground.com/shadowdom");
		gearIcon.click();
		System.out.println(editValue.getText());
		
	}

}