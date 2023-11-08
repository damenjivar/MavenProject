package com.tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
	}

	@Test
	public void checkingOutValidProduct() throws Exception {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
		driver.findElement(By.xpath("//div[@class = 'caption']/following-sibling::div/child::button[1]")).click();
		Thread.sleep(3000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//li[contains(text(), 'Product Code:Product 21')]")).isDisplayed());
		driver.findElement(By.xpath("//button[@id = 'button-cart']")).click();
		String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!";
		Thread.sleep(3000);
		String actualMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage));
		driver.findElement(By.xpath("//div[@id = 'cart']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Checkout")).click();

//		driver.findElement(By.xpath("//a[@class='accordion-toggle']")).click();
//		driver.findElement(By.xpath("//label/following::input[@name='account']")).click();
//		driver.findElement(By.xpath("//input[@id='button-account']")).click();

//		driver.findElement(By.name("search")).sendKeys("HP");
//		driver.findElement(By.cssSelector("i.fa.fa-search")).click(); //can you use this one instead?
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
//		driver.findElement(By.linkText("HP LP3065")).click(); //can you use link text instead of button? 
//		driver.findElement(By.id("button-cart")).click(); // could you just call it directly or better to use Xpath?
//		Assert.assertTrue(
//				driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).isDisplayed());

		// Checkout options
//		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
//		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

		// Billing details
		driver.findElement(By.xpath("//input[@name='payment_address']")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("selenium");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("panda");
		driver.findElement(By.id("input-payment-company")).sendKeys("PandaCompany");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("1 Panda St");
		driver.findElement(By.id("input-payment-address-2")).sendKeys("2 Panda St");
		driver.findElement(By.id("input-payment-city")).sendKeys("PandaCity");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("123");
		driver.findElement(By.id("input-payment-country")).click();
		driver.findElement(By.xpath("//option[@value='223']")).click();
		driver.findElement(By.xpath("//select[@id= 'input-payment-zone']")).click();
		driver.findElement(By.xpath("//option[@value='3614']")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); // ?
		driver.findElement(By.xpath("//input[@name='shipping_method']")).click();
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("send package to garageDoor");
		driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
		driver.findElement(By.xpath("//input[@name='payment_method']")).click();
		driver.findElement(By.xpath(
				"//div[@class='buttons']/preceding::textarea[@name='comment' and @class='form-control' and @rows=8]"))
				.sendKeys("cash payment");
		driver.findElement(By.xpath("//input[@name = 'agree']")).click();
		driver.findElement(By.xpath("//input[@id = 'button-payment-method']")).click();
		driver.findElement(By.xpath("//input[@id = 'button-confirm']")).click();
		String expectedOrderSuccessMessage = "Your order has been successfully processed!";
				
				
				
		//String actualOrderSuccessMessage = driver.findElement(By.xpath("//div[@class='col-sm-12']/child::p[1]"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}