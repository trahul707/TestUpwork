package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification res;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(res==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		res=new RequestSpecBuilder().setBaseUri(getGlobalProp("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.addHeader("Content-Type", "application/json").build();
		return res;
		}
		return res;
	}
	
	public static String getGlobalProp(String key) throws IOException
	{
		Properties p=new Properties();
		FileInputStream m=new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\global.properties"));
	    p.load(m);
	   return p.getProperty(key);
	}
	
	public String getJson(String result,String key)
	{
		JsonPath pt=new JsonPath(result);
		String value=pt.get(key);
		return value;
	}
	
	public Integer getJsonInteger(String result,String key)
	{
		JsonPath pt=new JsonPath(result);
		Integer value=pt.getInt(key);
		return value;
	}
	
}
