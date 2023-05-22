package com.ms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;

import com.ms.pages.Login_Page;

public class CommonMethods{
	public WebDriver driver=Runner.driverMap.get(Thread.currentThread().getId());
	
	
	public String loginWithProfile() throws Exception
	{
		String userId="";
		String password="";
		String url="";
		
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\resources\\Configuration.properties")));
			
			password=prop.getProperty("userPassword");
			url=prop.getProperty("url");
			return password;
			
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	 
	
	
	
}
