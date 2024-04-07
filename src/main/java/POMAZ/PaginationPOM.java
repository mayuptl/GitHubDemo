package POMAZ;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginationPOM {
	
	WebDriver driver;
	public PaginationPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tbody/tr/td[1]")
	List<WebElement> RowElements;
	@FindBy(xpath="//ul/li[7]")
	WebElement NextButton;
	List<WebElement> ProductName;
	public void Pg()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		do 
		{
			ProductName=RowElements.stream().filter(s->s.getText().contains("Carrot"))
					.map(m->GetMyProductName(m)).collect(Collectors.toList());
			if(ProductName.size()<1)
			{
				NextButton.click();
			}
		}while(ProductName.size()<1);
	}
	public WebElement GetMyProductName(WebElement m)
	{
		System.out.println(m.getText());
		// it will print very next value of Carrot
		System.out.println(m.findElement(By.xpath("following-sibling::td[1]")).getText());
		/* it will print all values next of Carrot
		List<WebElement>Price=m.findElements(By.xpath("following-sibling::td"));
		Price.stream().map(s->s.getText()).forEach(f->System.out.println(f)); */
		return m;
	}

}
