package step_definitions;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ddResultPage;
import pageobjects.ddHomePage;
import pageobjects.ddSearchPage;
import utility.DDGBase;



public class ddTCSearch {
	WebDriver driver = DDGBase.startBrowser();
	ddHomePage page1 = PageFactory.initElements(driver, ddHomePage.class);	
	ddResultPage page2 = PageFactory.initElements(driver, ddResultPage.class);
	ddSearchPage page3 = PageFactory.initElements(driver, ddSearchPage.class);
	
	@Given("^User navigate to DDG Home page$")
	public void guest_is_in_search_home_page() throws Throwable {
	   
		System.out.println("Given statement is executed");
	   
	    
	}

	@When("^User enter keyword <searchKey> to search$")
	public void user_enter_keyword_searchKey_to_search(DataTable table) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<String> data = table.asList(String.class);
		page1.gotoSearchKey(data.get(0));
		for(int i=1; i<data.size(); i++) {		
		page1.gotoSearchKey(data.get(i));
		page2.printRes();

		}
	}

	@Then("^Verify the top ten relevant results is printed for <searchKey>$")
	public void verify_the_top_ten_relevant_results_is_printed_for_searchKey() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page2.printRes();
		//DDGBase.captureScreenshot("searchKey");
		DDGBase.closeBrowser();
	}
}
