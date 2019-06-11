package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;




public class DDGBase {
	
	public static WebDriver driver;
	public static int maxTimeOut = 30;

	
	//Method returing value:
	public static WebDriver startBrowser() {
		try {
		String browsername = getrecords("browser");
		String browserurl = getrecords("url");
		
		if(browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox is loaded");
		}else if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", new File("/usr/local/bin/chromedriver").getAbsolutePath());
			driver = new ChromeDriver();
			System.out.println("Chrome is loaded");
		}else if(browsername.equalsIgnoreCase("iexplore")) {
			System.setProperty("webdriver.ie.driver",new File("src/test/resources/drivers/IEDriverServer.exe").getAbsolutePath());
			driver = new InternetExplorerDriver();
			System.out.println("IE is loaded");
		}else {
			System.out.println(browsername + "is not a supported browser");
		}
		Implicitwait(maxTimeOut);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(browserurl);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver;
	}
	
	public static void closeBrowser() {
		try {
			driver.close();
		}catch(Exception e) {
			
		}finally{
			driver.quit();
		}
	}
	
	
	public static void closeBrowserWithScreenshot(Scenario s) {
		try {
			if(s.isFailed()) {
			// Used to print message in report.
			s.write("********************************** Embedded - Failed Screenshot *************************************");
			s.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			s.write("********************************** Embedded - Failec Screenshot End *************************************");
			}else {
				// Used to print message in report.
				s.write("********************************** Embedded - Passed Screenshot *************************************");
				s.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
				s.write("********************************** Embedded - Passed Screenshot End *************************************");
			}
			driver.close();
		}catch(Exception e) {
					
		}finally{
			driver.quit();
		}
	}
	
	
	//Reading values from properties:
	
	public static String getrecords(String propertyname) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("src/test/resources/testdata/config.properties").getAbsolutePath());
		//FileInputStream fis = new FileInputStream("C:\\Users\\Prabhakaran\\NewWorkspace\\Sel_Cucumber\\src\\test\\resources\\testdata\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(propertyname);
	}
	
	// Apache- POI:
	// XSSF = xlsx, HSSF = xls 
	


	
	// Implicit and Explicit waits:
	
	public static void waitUntilElementClickable(int seconds, WebElement element){
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public static void waitUntilPageLoads(int seconds, String title){
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	
	public static void waitUntilElementVisible(int seconds, WebElement element){
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void waitUntilAlertPresent(int seconds){
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public static void Implicitwait(int seconds) {
		
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	// Alert Handling:
	
	public static void acceptAlert() {
		Alert popup = driver.switchTo().alert();
		popup.accept();
		// Hit OK or Enter or Yes
	}
	
	public static void dismissAlert() {
		Alert popup = driver.switchTo().alert();
		popup.dismiss();
		//hit Cancel or Esc or No
	}
	
	// Action related commands:
	// button, checkbox, radio button, link and popup
	public static void clickElement(WebElement element){
		element.click();
	}
	
	public static void clearCharacters(WebElement element){
		element.clear();
	}
	
	public static void typeCharacters(WebElement element, String value){
		element.sendKeys(value);
	}
	
	// DropDown and ListBoxes:
	// Select using Option displayed in dropdown
	public static void selectOption(WebElement element, String text){
		
		new Select(element).selectByVisibleText(text);
	}
	
	public static void selectIndex(WebElement element, int index){
		
		new Select(element).selectByIndex(index);
	}
	
	
	public static void selectValue(WebElement element, String value){
		
		new Select(element).selectByValue(value);
	}
	
	// Listbox deselection:
	
	public static void deselectOption(WebElement element, String text) {
		
		new Select(element).deselectByVisibleText(text);
	}
	
	public static void deselectIndex(WebElement element, int index) {
		
		new Select(element).deselectByIndex(index);
	}
	
	public static void deselectValue(WebElement element, String value) {
		
		new Select(element).deselectByValue(value);
	}
	
	// Navigation related commands:
	
	public static void navigateURL(String url) {
		driver.navigate().to(url);	
	}
	
	public static void goForward(){
		driver.navigate().forward();
	}
	
	public static void goBack(){
		driver.navigate().back();
	}
	
	public static void refreshPage(){
		driver.navigate().refresh();
	}
	
	
	//Storage command:
	
	public static boolean isElementDisplayed(WebElement element) {
		
		return element.isDisplayed();
	}
	
	// Title capturing
	public static String getPageTitle() {
		return driver.getTitle();
	}
	
	// URL Capturing 
	public static String getUrl() {
		return driver.getCurrentUrl();
	}
	
	// Text or Link or Label capturing
	
	public static String getText(WebElement element){
		
		return element.getText();
	}
	
	// capture button label, checkbox and radio button value, entered data from edit field:
	
	public static String getValue(WebElement element){
		
		return element.getAttribute("value");
	}
	
	// Capture Tooltip of element:
	
	public static String getTooltip(WebElement element){
		
		return element.getAttribute("title");
	}
	
	// Capture Dropdown and Listbox
	
	public static String getSelectedOption(WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
		
	}
	
	// List box to capture value:
	
	public static List<WebElement> getAllSelectedOption(WebElement element) {
		return new Select(element).getAllSelectedOptions();
		
	}
	
	// Both listbox and dropdown
	public static List<WebElement> getAllOptions(WebElement element) {
		return new Select(element).getOptions();
		
	}
	
	// Capture Alert message:
	
	public static String getAlertMessage(){
		Alert popup = driver.switchTo().alert();
		return popup.getText();
	}
	
	// Boolean functions:
	// check alert is present or not 
	
	public static boolean isAlertPresent(){
		
		try {
			Alert popup = driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	// Element present:
	
	
	public static boolean isElementEnabled(WebElement element) {
		try {
				element.isEnabled();
				 return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isElementSelected(WebElement element) {
		try {
			
				 element.isSelected();
				 return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	//Multi-Window Handling:
	
	public static void switchWindow(String expTitle){
		
		for(String childwindow : driver.getWindowHandles()) {
			System.out.println("Switch focus window ID: " +childwindow);
			
			driver.switchTo().window(childwindow);
			
			if(expTitle.equalsIgnoreCase(getPageTitle())) {
				System.out.println("Current page focus: " +expTitle);
				break;
			}
		}
	}
	
	
	//Mouse Howering Techniques:
	
	public static void mouseHower(WebElement element) {
		
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).build().perform();
	}
	
	public static void mouseClick(WebElement element) {
		
		Actions mouse = new Actions(driver);
		mouse.click(element).build().perform();
	}
	
	public static void mouseDoubleClick(WebElement element) {
		
		Actions mouse = new Actions(driver);
		mouse.doubleClick(element).build().perform();
	}
	
	public static void mouseRightClick(WebElement element) {
		
		Actions mouse = new Actions(driver);
		mouse.contextClick(element).build().perform();
	}
	
	public static void mouseDragDrop(WebElement source, WebElement dest) {
		
		Actions mouse = new Actions(driver);
		mouse.dragAndDrop(source, dest).build().perform();
	}
	
	// Keyboard related functions: One Key Action
	
	public static void keyStrokes(WebElement element, Keys key){
		
		element.sendKeys(key);
	}
	
	// Iframe Handling:
	// One class can contain multiple methods with same name provided either no. of arguments or type of argument should be different 
	
	public void suitchFrameUsingName(String name) {
		driver.switchTo().frame(name);
	}
	
	public void suitchFrameUsingIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void suitchFrameUsingElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void comeOutOfFrame(){
		driver.switchTo().defaultContent();
	}
	
	//Keystorkes : Chord method:
	
	// Find total elements:
	
	public static int getTotalElements(String xpath) {
		
	return driver.findElements(By.xpath(xpath)).size();
	}

	//Capture Screenshot:
	
	public static void captureScreenshot(String filename) throws IOException {
			System.out.println("am here to print something");
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("/src/test/java/screenshots/" + filename +".png"));
	}
}
