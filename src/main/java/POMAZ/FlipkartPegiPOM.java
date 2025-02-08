package POMAZ;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPegiPOM {
	WebDriver driver;
	public FlipkartPegiPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//
	
	//
	@FindBy (css="._30XB9F")
	WebElement LoginWindowX;
	@FindBy (css="input[name='q']")
	WebElement SearchBox;
	/*	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}*/
	@FindBy(css="._4rR01T")
	List<WebElement> NameList;
	By NameListBY=By.cssSelector("._4rR01T");
	@FindBy(css="img[alt='vivo T2x 5G (Marine Blue, 128 GB)']")
	WebElement imgOfMobile;
	@FindBy(xpath="//a[@class='_1LKTO3']//span[text()='Next']")
	WebElement Next;
	
	public void FindMayMobile(String MobileName) throws InterruptedException
	{
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
			try
			{
				LoginWindowX.click();
			}
			catch(Exception e)
			{
				SearchBox.click();
			}
		Actions a=new Actions(driver);
		a.moveToElement(SearchBox).click().sendKeys("Mobile Phones 5g").keyDown(Keys.ENTER).build().perform();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement>MobileName1;
		do
			{
				// if stealrefer error cause then use presenceOfAllElementsLocatedBy
				// w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(NameListBY));
				// w.until(ExpectedConditions.elementToBeClickable(NameListBY));
				// a.pause(Duration.ofSeconds(3)).build().perform();
				Thread.sleep(2000);
				//List<WebElement> NameList=driver.findElements(By.cssSelector("._4rR01T"));
				MobileName1=NameList.stream().filter(s->s.getText().contains(MobileName))
					.map(m->MyDevice(m)).collect(Collectors.toList());
				if(MobileName1.size()<1)
				{
					w.until(ExpectedConditions.visibilityOf(Next));
					Next.click();
				}
			}while(MobileName1.size()<1);
		}
	public WebElement MyDevice(WebElement m)
	{
		System.out.println(m.getText());
		m.click();
		return m;
	}
	@FindBy (css="._30jeq3._16Jk6d")
	WebElement price;
	/*	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}*/
	public void getMobileInfo()
	{
		Set<String> win=driver.getWindowHandles();
		Iterator<String> it=win.iterator();
		it.next();
		String ChildWin=it.next();
		driver.switchTo().window(ChildWin);
		System.out.println(price.getText());
	}
		
}

