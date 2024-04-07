package POMAZ;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicTablePOM {
	WebDriver driver;
	public DynamicTablePOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@role='rowgroup']/div")
	List<WebElement> RowGroup; // getting Each row group
	@FindBy(css=".bg-warning")
	WebElement SiteText; //Actual text
	
	String Before="span["; // Customized xpath
	String After="]";	   // Customized xpath
	int m=1; // veriable for itration
	String[] values=new String[2]; // String array for return Bcoz we are returning multiple strings
	
	public String[] findOut2()
	{
		driver.get("http://uitestingplayground.com/dynamictable");
		values[0]=SiteText.getText(); // Adding Actual text in the array [which displayed on web page]
		RowGroup.stream().filter(s->s.findElement(By.xpath("span")).getText()
				.equalsIgnoreCase("Chrome")).map(p->getPercentage(p)).collect(Collectors.toList());
		
		return values; // returing string array
	}
	
	public WebElement getPercentage(WebElement p) 
	{
		for(int i=1;i<5;i++)
			{
				m++;
				String CPUpercentage =p.findElement(By.xpath(Before+m+After)).getText();
				
				if(CPUpercentage.endsWith("%"))
				{
					values[1]= CPUpercentage;
					break;
				}
			}
		return p;	
	}
	/* working code
	public String[] findOut1()
	{
		driver.get("http://uitestingplayground.com/dynamictable");
		
		WebElement chr=RowGroup.stream().filter(s->s.findElement(By.xpath("span")).getText()
		 .equalsIgnoreCase("Chrome")).findFirst().orElse(null); // Getting Chrome Row Group
		
		values[0]=SiteText.getText(); // Adding Actual text in the array [which displayed on web page]
		
		for(int i=1;i<5;i++)
			{
				m++;
				String CPUpercentage =chr.findElement(By.xpath(Before+m+After)).getText();
				if(CPUpercentage.endsWith("%"))
					{
						values[1]= CPUpercentage;
						break;
					}
				}				
		return values; // returing string array
	}
	// Working code
	public void findOut()
	{
		driver.get("http://uitestingplayground.com/dynamictable");
		List<WebElement>chr=RowGroup.stream().filter(s->s.findElement(By.xpath("span")).getText()
				.equalsIgnoreCase("Chrome")).collect(Collectors.toList());
			
		for(int i=0;i<chr.size();i++)
		{
				String Before="span[";
				String After="]";
				
				String my2=chr.get(i).findElement(By.xpath(Before+2+After)).getText();
				if(my2.endsWith("%"))
				{
					System.out.print("Chrome CPU: "+my2+"\n");
					break;
				}
				String my3=chr.get(i).findElement(By.xpath(Before+3+After)).getText();
				if(my3.endsWith("%"))
				{
					System.out.print("Chrome CPU: "+my3+"\n");
					break;
				}
				String my4=chr.get(i).findElement(By.xpath(Before+4+After)).getText();
				if(my4.endsWith("%"))
				{
					System.out.print("Chrome CPU: "+my4+"\n");
					break;
				}
				String my5=chr.get(i).findElement(By.xpath(Before+5+After)).getText();
				if(my5.endsWith("%"))
				{
					System.out.print("Chrome CPU: "+my5+"\n");
					break;
				}
		}
				
	} */

}
