package com.ms.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.ms.pages.Login_Page;

public class TWebElement extends RemoteWebElement implements WebElement {
	private WebDriver driver;
	private static Map<Object, String> mapFields=new HashMap<Object, String>();
	private WebElement ele;
	private By loc=null;
	
	Login_Page lp=new Login_Page();
	
	public TWebElement(WebDriver driver,By loc)
	{
		this.driver=driver;
		if(mapFields.size()<=0)
		{
			getAllClasses();
		}
		this.loc=loc;
	}
	 public void getAllClasses()
	 {
		 File folder=new File ("src//main//java//com//ms//pages");
		 File[] files=folder.listFiles();
		 
		 for(File file: files) {
			 try {
				 Class<?> c=Class.forName("com.ms.pages."+file.getName().split(".java")[0]);
				 c.getDeclaredFields();
				 Object obj =c.newInstance();
				 for(Field fld:c.getDeclaredFields()) {
					 try {
						 mapFields.put(fld.get(obj),fld.getName());
						 
					 }catch(Exception e)
					 {
						 
					 }
				 }
			 }catch(Exception e1) {
				 e1.printStackTrace();
			 }
		 }
	 }
}
