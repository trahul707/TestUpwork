package resources;

import java.util.ArrayList;

import pojo.Add;


public class TestDataFromPojo {

	public Add addPlace(String title, String body, Integer userId)
	{
		Add a=new Add();
		a.setTitle(title);
		a.setBody(body);
		a.setUserId(userId);
		
		return a;
	}
	
	public Add updatePlace(String title, String body, Integer userId, Integer id)
	{
		Add a=new Add();
		a.setTitle(title);
		a.setBody(body);
		a.setUserId(userId);
		a.setId(id);
		
		return a;
	}
}
