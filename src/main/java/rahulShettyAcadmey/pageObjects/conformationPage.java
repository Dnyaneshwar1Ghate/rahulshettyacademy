package rahulShettyAcadmey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class conformationPage extends AbstractComponent{
	
	WebDriver driver;
	public conformationPage(WebDriver driver) {
		super(driver);
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement conformationPages;
	public String verfyConformationPage()
	{
		return conformationPages.getText();
	}
	



}