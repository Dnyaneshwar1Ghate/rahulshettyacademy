package rahulShettyAcadmey.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement Country;
	

	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By result=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryname)
	{
		Actions a = new Actions(driver);
		
		a.sendKeys(Country, countryname).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public conformationPage submitOrder()
	{
		submit.click();
		return new conformationPage(driver);
		
	}
}