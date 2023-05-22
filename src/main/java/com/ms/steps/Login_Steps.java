package com.ms.steps;

import com.ms.pages.Login_Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login_Steps {
	Login_Page lp=new Login_Page();
	@Given("User launch the facebook")
	public void user_launch_the_facebook() {
		lp.openUrl();
	}

	@Given("User login to facebook with {string}")
	public void user_login_to_facebook_with(String name) throws Exception {
	  lp.accountLogin(name);
	}

	@When("User verify login is success")
	public void user_verify_login_is_success() throws Exception {
	    lp.verifyFBHeader();
	}

	@Given("User login to facebook with incorrect password {string}")
	public void user_login_to_facebook_with_incorrect_password(String name) throws Exception {
	    lp.accountLoginWrong(name);
	}

	@When("User verify login is failed")
	public void user_verify_login_is_failed() throws Exception {
	lp.verifyErrorMessage();
	}
	
	@When("User close the browser")
	public void userClose() throws Exception {
	lp.closeBrow();
	}
	
}
