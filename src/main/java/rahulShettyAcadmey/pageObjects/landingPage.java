package rahulShettyAcadmey.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class landingPage extends AbstractComponent {
	WebDriver driver;

	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory
	@FindBy(id = "userEmail")
	WebElement UserEmail;

	@FindBy(id = "userPassword")
	WebElement UserPass;

	@FindBy(id = "login")
	WebElement submit;


	@FindBy(css = "[class*=flyInOut]")
	WebElement errorMessage;
	
	public productCatlog loginApplication(String email, String password) {
		UserEmail.sendKeys(email);
		UserPass.sendKeys(password);
		submit.click();
		productCatlog productCatLogue = new productCatlog(driver);
		return productCatLogue;

	}

	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		 
	}
	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}

}