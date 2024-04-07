package POMAZ;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPegiPOM {
	WebDriver driver;
	public AmazonPegiPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".a-size-base-plus.a-color-base.a-text-normal")
	List<WebElement> prodList;
	@FindBy(css=".s-pagination-next")
	WebElement Next;
	List<Object> sortedProdList;
	public void FindShoe(String ShoeName) throws InterruptedException
	{
		driver.get("https://www.amazon.in/s?k=shoes+for+men&qid=1693326216&sprefix=sho%2Caps%2C203&ref=sr_pg_1");
		do
		{
			Thread.sleep(2000);
		//	prodList.stream().map(m->m.getText()).forEach(f->System.out.println(f));
			sortedProdList=prodList.stream().filter(s->s.getText().equalsIgnoreCase(ShoeName))
					.map(m->GetMyProd(m)).collect(Collectors.toList());
			if(sortedProdList.size()<1)
			{
				Next.click();
			}
		}while(sortedProdList.size()<1);	
	}
	public WebElement GetMyProd(WebElement m)
	{
		System.out.println(m.getText());
		m.click();
		return m;
	}

}
