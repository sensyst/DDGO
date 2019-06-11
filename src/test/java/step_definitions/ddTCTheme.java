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
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.ddHomePage;
import utility.DDGBase;

public class ddTCTheme {

	WebDriver driver = DDGBase.startBrowser();
	
	ddHomePage page1 = PageFactory.initElements(driver, ddHomePage.class);

	
	@Given("^Guest user on home page$")
	public void guest_user_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^user load the settings menu$")
	public void user_load_the_settings_menu() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    page1.gotoSlideOutmenu();
	    page1.pause(500);
	}

	@When("^selects theme menu item$")
	public void selects_theme_menu_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    page1.selectMenuItem();
	}

	@When("^select the theme type$")
	public void select_the_theme_type() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		page1.setTheme();
	}

	@When("^select the saveExit$")
	public void select_the_saveExit() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^the theme color is applied$")
	public void the_theme_color_is_applied() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("ThemeApplied");
	    DDGBase.closeBrowser();
	}
}
