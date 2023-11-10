package com.tutorialsninja.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest {

	public WebDriver driver;
	public Select select;

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class = 'col-sm-12']/descendant::input[1]")).click();
		driver.findElement(By.id("input-email")).sendKeys("seleniumpanda@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input#button-login")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class = 'col-sm-12']/descendant::input[2]")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("selenium");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("panda");
		driver.findElement(By.id("input-payment-company")).sendKeys("PandaCompany");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("1 Panda St");
		driver.findElement(By.id("input-payment-address-2")).sendKeys("2 Panda St");
		driver.findElement(By.id("input-payment-city")).sendKeys("PandaCity");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("123");
		Select select = new Select(driver.findElement(By.id("input-payment-country")));
		select.selectByVisibleText("United States");
		Thread.sleep(3000);
		Select select1 = new Select(driver.findElement(By.id("input-payment-zone")));
		select1.selectByVisibleText("California");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@class = 'col-sm-12']/descendant::div[@id = 'shipping-existing']/following::input[1]"))
				.click();
		driver.findElement(By.id("input-shipping-firstname")).sendKeys("SELENIUM");
		driver.findElement(By.id("input-shipping-lastname")).sendKeys("PANDA");
		driver.findElement(By.id("input-shipping-company")).sendKeys("PANDACOMPANY");
		driver.findElement(By.id("input-shipping-address-1")).sendKeys("1 PANDA ST");
		driver.findElement(By.id("input-shipping-address-2")).sendKeys("2 PANDA ST");
		driver.findElement(By.id("input-shipping-city")).sendKeys("PANDACITY");
		driver.findElement(By.id("input-shipping-postcode")).sendKeys("123123");
		Select select2 = new Select(driver.findElement(By.id("input-shipping-country")));
		select2.selectByVisibleText("United States");
		Select select3 = new Select(driver.findElement(By.id("input-shipping-zone")));
		select3.selectByVisibleText("Virginia");
		driver.findElement(By.id("button-shipping-address")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='shipping_method']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class = 'col-sm-12']/descendant::textarea[1]"))
				.sendKeys("send package to garageDoor");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='payment_method']")).click();
		driver.findElement(By.xpath("//div[@id = 'collapse-payment-method']/descendant::textarea[1]"))
				.sendKeys("cash payment");
		driver.findElement(By.xpath("//input[@name = 'agree']")).click();
		driver.findElement(By.xpath("//input[@id = 'button-payment-method']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id = 'button-confirm']")).click();
		String expectedOrderSuccessMessage = "Your order has been successfully processed!";
		Thread.sleep(3000);
		String actualOrderSuccessMessage = driver.findElement(By.xpath("//div[@class = 'col-sm-12']/child::p[1]"))
				.getText();
		Assert.assertTrue(actualOrderSuccessMessage.contains(expectedOrderSuccessMessage));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id = 'cart']")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}