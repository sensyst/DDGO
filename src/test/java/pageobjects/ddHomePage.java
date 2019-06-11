package pageobjects;

import utility.DDGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

public class ddHomePage {


	//Page Factory
	@FindBy(xpath="//input[@id='search_form_input_homepage']")
	public WebElement search_form_input_homepage;
	
	
	
	
	@FindBy(xpath="//*[@class = 'search__button  js-search-button']")
	public WebElement search_button_homepage;
	
	@FindBy(xpath ="//*[@id='pg-index']/div/div[4]/ul/ul[1]/li[2]/a")
	public WebElement Thememenu;
	
	
	@FindBy(xpath="//*[@class = 'header__button--menu  js-side-menu-open']")
	public WebElement sideMenu;
	
	
	@FindBy(xpath="//*[@id='content_internal']/div[1]/div[1]/div[2]/form/div/div/div[4]/label[1]")
	public WebElement ThemeType;
	
	@FindBy(xpath="//*[@id='content_internal']/div[1]/div[1]/div[3]/a")
	public WebElement saveButton;
	
	//*[@id='content_internal']/div[1]/div[1]/div[3]/a
	
	@FindBy(xpath="//*[@class = 'logo_homepage']")
	public WebElement logoImage;
	
	public void logoPresent() {
		
		if (logoImage.isDisplayed() == true ){
			System.out.println("Logo is present");
		}
		else {
			System.out.println("Logo is not present");
		
		}
	}
	
	
	public void gotoSearchKey(String searchtext) {
		
		search_form_input_homepage.clear();
		search_form_input_homepage.sendKeys(searchtext);
	}
	
	public void gotoSearch(DataTable searchtext) {
		
		List<String> data = searchtext.asList(String.class);;
		
		search_form_input_homepage.clear();
		search_form_input_homepage.sendKeys(data.get(1));;
	    search_button_homepage.submit();
	}
	
	public void pause(Integer milliseconds){
	    try {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void gotoSlideOutmenu() {

		sideMenu.click();
		
	}
	
	public void selectMenuItem() {
		if (Thememenu.isDisplayed()) {
		Thememenu.click();
		}
	}
	public void setTheme() {
		ThemeType.click();
		saveButton.click();
		
	}
	
	public void submitSearchKey() {
		
		search_button_homepage.submit();
	}


}
