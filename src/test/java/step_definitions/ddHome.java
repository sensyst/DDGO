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

public class ddHome {
	
	WebDriver driver = DDGBase.startBrowser();
	
	ddHomePage page1 = PageFactory.initElements(driver, ddHomePage.class);
	

	@Given("^Guest is in search home page$")
	public void guest_is_in_search_home_page() throws Throwable {
	   
		System.out.println("Given statement is executed");
	   
	    
	}

	@When("^guest enter keyword to search$")
	public void guest_enter_keyword_to_search() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page1.gotoSearchKey("super");
	  
	}

	@When("^click search button$")
	public void click_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page1.submitSearchKey();
	    
	}

	@Then("^the top ten relevant content is displayed$")
	public void the_top_ten_relevant_content_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("then statement is executed");
	}
}
