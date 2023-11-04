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

//		driver.findElement(By.name("search")).sendKeys("HP");
//		driver.findElement(By.cssSelector("i.fa.fa-search")).click();
//		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
//
//		driver.findElement(By.linkText("HP LP3065")).click();
//		Assert.assertTrue(driver.findElement(By.id("button-cart")).isDisplayed());
//
//		driver.findElement(By.id("button-cart")).click();
//		Assert.assertTrue(
//				driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).isDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
