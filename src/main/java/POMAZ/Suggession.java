package POMAZ;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Suggession {
	WebDriver driver;
	
	public Suggession(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css="#autocomplete")
	WebElement inputText;
	@FindBy (xpath="//ul[@id='ui-id-1']/li/div")
	List<WebElement> ListCountryName;
	/*	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}*/
	public void SelectGivenCountry(String NameChar,String CountryName)
	{
		inputText.sendKeys(NameChar);
		WebElement MyCountry=ListCountryName.stream().filter(s->s.getText()
				.equalsIgnoreCase(CountryName)).findAny().orElse(null);
		MyCountry.click();
	}
}
