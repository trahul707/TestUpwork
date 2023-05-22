package com.ms.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Runner {
private WebDriver driver;
public static Map<Long,WebDriver> driverMap=new HashMap<Long, WebDriver>();

@BeforeClass(alwaysRun=true)
	public void launchChrome()
	{
		long threadId=Thread.currentThread().getId();
System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	    
	    //Instantiating driver object and launching browser
	   driver = new ChromeDriver();
	   WebDriver driverName=driver;
	   driverMap.put(threadId, driverName);
	   System.out.println("chrome browser started");
	  
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	}
}
