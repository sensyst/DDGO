package pageobjects;



import utility.DDGBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import org.openqa.selenium.Keys;

public class ddResultPage {


	
	
	@FindBy(xpath="//*[@id='links']//h2/a[@class='result__a']")
	public List<WebElement> resultsList;


	
	public void printRes() {
    for (WebElement webElement : resultsList)
    	{
        System.out.println(webElement.getAttribute("href"));
    	}
	}

}
