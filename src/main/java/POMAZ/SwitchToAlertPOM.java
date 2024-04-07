package POMAZ;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToAlertPOM {

	WebDriver driver;
	public SwitchToAlertPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="alertbtn")
	WebElement alertBtn;
	@FindBy(id="confirmbtn")
	WebElement confirmBtn;
	public void GenrateAlert()
	{
		alertBtn.click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		confirmBtn.click();
		driver.switchTo().alert().dismiss();
	}
}
