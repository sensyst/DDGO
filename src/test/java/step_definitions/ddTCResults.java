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
import pageobjects.ddResultPage;
import pageobjects.ddHomePage;

import utility.DDGBase;


public class ddTCResults {
	
	
WebDriver driver = DDGBase.startBrowser();
	
	ddHomePage page1 = PageFactory.initElements(driver, ddHomePage.class);	
	ddResultPage page2 = PageFactory.initElements(driver, ddResultPage.class);
	
	
	@Given("^Guest is in results page$")
	public void guest_is_in_results_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("am i here");
		page1.gotoSearchKey("supercalafragalisticexpialadoshus");
	    
	}

	@When("^The results are displayed$")
	public void the_results_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("am i here too");
		
	  
	}

	@Then("^The top ten results are printed$")
	public void the_top_ten_results_are_printed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page2.printRes();
		
	}
	
	

}
