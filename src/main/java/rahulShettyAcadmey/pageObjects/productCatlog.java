package rahulShettyAcadmey.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class productCatlog extends AbstractComponent {

	WebDriver driver;

	public productCatlog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By tostMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {

		waitForElementToAppear(productsBy);
		return products;

	}

	public WebElement getProductByName(String productName) {
		WebElement pro = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return pro;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement Prod = getProductByName(productName);
		Prod.findElement(addToCart).click();
		waitForElementToAppear(tostMessage);
		waitForElementToDisAppear(spinner);

	}

}