package step_definitions;

import java.io.IOException;

import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pageobjects.ddHomePage;
import utility.DDGBase;

public class ddTCLogo {
	
	WebDriver driver = DDGBase.startBrowser();
	ddHomePage page1 = PageFactory.initElements(driver, ddHomePage.class);
	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^I look at the page$")
	public void i_look_at_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^I expect to see ddg logo$")
	public void i_expect_to_see_ddg_logo() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   page1.logoPresent();
	   //DDGBase.captureScreenshot("ddogo");
	}

}
