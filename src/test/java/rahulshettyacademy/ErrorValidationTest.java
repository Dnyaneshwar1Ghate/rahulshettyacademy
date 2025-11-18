package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Duplication;
import rahulShettyAcadmey.pageObjects.CartPage;
import rahulShettyAcadmey.pageObjects.CheckOutPage;
import rahulShettyAcadmey.pageObjects.conformationPage;
import rahulShettyAcadmey.pageObjects.productCatlog;
import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest{

	@Test
	public void loginErrorValidation() throws IOException, InterruptedException
	{

		String proDuctName = "IPHONE 13 PRO";
		
		
		productCatlog productCatLogue = landingPage.loginApplication("dnyanegshwarghate1010@gmail.com", "Dghate@2025");
		Assert.assertEquals(" Incorrect email or password.",landingPage.getErrorMessage());
	
		

	}
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
		String proDuctName = "IPHONE 13 PRO";

		
		productCatlog productCatLogue = landingPage.loginApplication("dnyaneshwarghate1010@gmail.com", "Dghate@2025");

		List<WebElement> products = productCatLogue.getProductList();
		productCatLogue.addProductToCart(proDuctName);

		CartPage cartpage = productCatLogue.gotoCartPage();

		Boolean match = cartpage.VeryFyProductDisplay("IPHONE 14 PRO");
		Assert.assertFalse(match);
	}

}