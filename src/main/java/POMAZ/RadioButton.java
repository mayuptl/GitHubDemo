package POMAZ;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButton {

	WebDriver driver;
	public RadioButton(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='radio1']")
	WebElement RdBtn;
	
	public void RdBtn()
	{
		System.out.println(RdBtn.getText());
	}
	
	@FindBy(xpath="//div[@id='radio-btn-example']/fieldset/label")
	List<WebElement> RdbtnNameList;
	@FindBy(css=".radioButton")
	List<WebElement> RdbtnList;
	
	public void RdBtn1()
	{
	//	RdbtnNameList.stream().map(m->m.getText()).forEach(s->System.out.println(s));
	//	RdbtnList.stream().filter(s->s.isSelected());
		for(WebElement s:RdbtnList)
		{
			if(s.isSelected()==false)
			{
				//s.click();
				System.out.println(s.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label")).getText());
			}
		}
	}
}
