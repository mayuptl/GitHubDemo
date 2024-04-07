package POMAZ;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionClassPOM {

	WebDriver driver;
	public ActionClassPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="mousehover")
	WebElement mHover;
	
	public void mouseHover()
	{
		ScrollDown1100();
		Actions a =new Actions(driver);
		a.moveToElement(mHover).build().perform();
	}
	@FindBy(id="name")
	WebElement nameTxtBox;
	public void keyEvent()
	{
		Actions a =new Actions(driver);
		a.moveToElement(nameTxtBox).click().keyDown(Keys.SHIFT).sendKeys("mayur").build().perform();
		
	}
	@FindBy(css=".blinkingText")
	WebElement blinkLink;
	public void rightClick()
	{
		Actions a =new Actions(driver);
		a.contextClick(blinkLink).build().perform();
	}
	@FindBy(css="#column-a")
	WebElement Adesti;
	@FindBy(css="#column-b")
	WebElement Bsource; 
	public void DragNDrop()
	{
		
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		Actions a =new Actions(driver);
		//a.moveToElement(Bsource).pause(Duration.ofSeconds(2)).dragAndDrop(Bsource, Adesti).build().perform();
		a.dragAndDrop(Bsource, Adesti).build().perform();
	
	}
	@FindBy(xpath="//iframe[@class='demo-frame lazyloaded']")
	WebElement frame;
	@FindBy(xpath="//h5[text()='High Tatras']")
	WebElement Source;
	@FindBy(xpath="//div[@id='trash']")
	WebElement Destination;
	public void DragNDrop1()
	{
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.switchTo().frame(frame);
		Actions A=new Actions(driver);
		A.dragAndDrop(Source, Destination).build().perform(); 
	}
	
	public void ScrollDown1100()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
	}
	
}
