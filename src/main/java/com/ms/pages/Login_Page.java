package com.ms.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.ms.utils.CommonMethods;
import com.ms.utils.Runner;

public class Login_Page {
	
	public static WebDriver driver;
	public By userName=By.xpath("//input[@name='email']");
	public By password=By.xpath("//input[@name='pass']");
	public By BtnLogin=By.xpath("//button[@name='login']");
	public By fbHeader=By.xpath("//span[contains(text(),'Upload a profile picture')]");
	public By errorMsg=By.xpath("//a[contains(@href,'error')]");
	CommonMethods m=new CommonMethods();
	Runner r=new Runner();
	public void accountLogin(String name) throws Exception
	{
		driver.findElement(userName).sendKeys(name);
		driver.findElement(password).sendKeys(m.loginWithProfile());
		driver.findElement(BtnLogin).click();
	
	}

	public void openUrl()
	{
		r.launchChrome();
		 driver=Runner.driverMap.get(Thread.currentThread().getId());
		
		 driver.get("https://www.facebook.com/login");	
	}
	
	public void accountLoginWrong(String name) throws Exception
	{
		
		driver.findElement(userName).sendKeys(name);
		driver.findElement(password).sendKeys("123");
		driver.findElement(BtnLogin).click();
	
	}
	
	public void verifyErrorMessage() throws Exception
	{
		Assert.assertTrue(driver.findElement(errorMsg).isDisplayed());
	}
	
	public void verifyFBHeader() throws Exception
	{
		Assert.assertTrue(driver.findElement(fbHeader).isDisplayed());
	}
	
	public void closeBrow() throws Exception
	{
		driver.quit();
	}
}
