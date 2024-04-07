package POMAZ;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPOM {

	WebDriver driver;
	public CheckBoxPOM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#checkbox-example fieldset label")
	List<WebElement> checkBoxNameList;
	
	@FindBy(css="#dropdown-class-example")
	WebElement d;
	public void checkBoxCheck(String option)
	{
		checkBoxNameList.stream().map(s->s.getText()).forEach(m->System.out.println("Avaliable option's are "+m));
		
	//	List<Object> ss=
				checkBoxNameList.stream().filter(s->s.getText().equalsIgnoreCase(option))
				.map(m->clickMyOption(m)).collect(Collectors.toList());
	
	//ss.stream().forEach(s->System.out.println("You have selected :"+ s));
	
	}
	public Object clickMyOption(WebElement m)
	{
	//	String O=m.getText();
		m.findElement(By.xpath("input")).click();
		//d.click();
		//return O;
		return m;
	}
}
