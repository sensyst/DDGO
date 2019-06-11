package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;

public class ddSearchPage {
	//Page Factory
		@FindBy(xpath="//input[@id='search_form_input']")
		public WebElement SearchInputField;
		

		@FindBy(xpath="//*[@id='search_button']")
		public WebElement SearchBttn;
		
		@FindBy(xpath="//*[@id='links']//h2/a[@class='result__a']")
		public List<WebElement> resultsList;

		
		public void gotoSearch(String searchtext) {
			
			
			SearchInputField.clear();
			SearchInputField.sendKeys(searchtext);;
			SearchBttn.submit();
		}



		
		public void printRes() {
	    for (WebElement webElement : resultsList)
	    	{
	        System.out.println(webElement.getAttribute("href"));
	    	}
		}

		
		public void submitSearch() {
			
			SearchBttn.submit();
		}


}
