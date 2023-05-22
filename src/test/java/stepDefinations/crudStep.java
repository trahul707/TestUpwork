package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Add;
import resources.Constants;
import resources.TestDataFromPojo;
import resources.Utils;

public class crudStep extends Utils {
	ResponseSpecification re;
	RequestSpecification resy;
	Response response;
	static Response ret;
	TestDataFromPojo td=new TestDataFromPojo();
	@Given("User enters headers, Params, body {string} {string} {string}")
	public void user_enters_headers_params_body(String title, String body, String userId) throws IOException {
		String myString = userId;
		int foo = Integer.parseInt(myString);
		
	resy=given().spec(requestSpecification())
		.body(td.addPlace(title,body,foo));
	  
	}
	
	@Given("User updates headers, Params, body {string} {string} {string} {string}")
	public void user_updates_headers_params_body(String title, String body, String userId,String id) throws IOException {
		String myString = userId;
		int foo = Integer.parseInt(myString);
		String myString1 = id;
		int foo1 = Integer.parseInt(myString1);
	resy=given().spec(requestSpecification())
		.body(td.updatePlace(title,body,foo,foo1));
	  
	}
	@When("User calls {string} using {string} http request")
	public void user_calls_using_post_http_request(String resource, String method) {
		Constants rs=Constants.valueOf(resource);
		System.out.println(rs.getResource());
		re=new ResponseSpecBuilder().build();
		if(method.equalsIgnoreCase("Post")) {
		response=resy.when().post(rs.getResource());
		}
		else if(method.equalsIgnoreCase("Get"))
		{
		response=resy.when().get(rs.getResource());
		}
		else if(method.equalsIgnoreCase("Put"))
		{
		response=resy.when().get(rs.getResource());
		}
		else if(method.equalsIgnoreCase("Delete"))
		{
		response=resy.when().get(rs.getResource());
		}
				
		
	}
	@Then("User verify that status code is {int}")
	public void user_verify_that_status_code_is(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   Assert.assertEquals(ret.getStatusCode(),int1);
	}
	@Then("User verify {string} in response body in {string}")
	public void user_verify_in_response_body_in(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	    String result=ret.asString();
	    
	    //JsonPath js=new JsonPath(result);
	    String actualStatus=getJson(result,key);
	    Assert.assertEquals(actualStatus, value);
	}
	
	@Then("User verify {string} in response body {string}")
	public void user_verify_in_response_body(String key, String value) {
	    // Write code here that turns the phrase above into concrete actions
	    String result=ret.asString();
	    String myString = value;
		int foo = Integer.parseInt(myString);
	    //JsonPath js=new JsonPath(result);
	    Integer actualStatus=getJsonInteger(result,key);
	    
		
	    Assert.assertEquals(actualStatus, foo);
	}
	
	
	@Then("user stores {string} value from response")
	public String getValueFromResponse(String value)
	{
		 String result=ret.asString();
		    //JsonPath js=new JsonPath(result);
		    String storeValue=getJson(result,value);
		    System.out.println(storeValue);
		   return storeValue;
	}
	
	@Then("user store {string} value from response")
	public Integer getValueFromResponseInteger(String value)
	{
		 String result=ret.asString();
		    //JsonPath js=new JsonPath(result);
		    Integer storeValue=getJsonInteger(result,value);
		    System.out.println(storeValue);
		   return storeValue;
	}
	
	@Given("User enters params {string} got from other api response")
	public void user_enters_params(String value) throws IOException {
		String paramValue=getValueFromResponse(value);
	resy=given().spec(requestSpecification()).queryParam(value, paramValue);
	
	
	}
	
	@Given("User enters param {string} got from other api response")
	public void user_enters_param(String value) throws IOException {
		Integer paramValue=getValueFromResponseInteger(value);
	resy=given().spec(requestSpecification()).queryParam(value, paramValue);
	
	
	}
	
	@Then("user gets the reponse")
	public void storeResponse() {
	 ret=response.then().spec(re).extract().response();

	}

}
