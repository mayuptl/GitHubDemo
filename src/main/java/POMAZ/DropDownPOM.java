package POMAZ;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPOM {
WebDriver driver;
	public DropDownPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="#dropdown-class-example")
	WebElement drpClick;
	@FindBy(css="div[class='cen-right-align'] fieldset select")
	WebElement drpOption;
	
	public void selectDropDown()
	{
		// Dropdown which start with select attribute
		Select s=new Select(drpClick);
		s.selectByIndex(2);
		s.selectByValue("option3");
		
		// if Dropdown which start other than select attribute then grab dropdown list in webelement list and apply stream
		// and select your option
	}
	
}
