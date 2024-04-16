package commonMethods_InsSers;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions_InsSers {
	
	public static void click(WebElement webUI) {
		webUI.click();
	}
	
	public static void sendKeys(WebElement webUI, String textToSend) throws InterruptedException {
		webUI.sendKeys(textToSend);
		Thread.sleep(1000);
	}
	
	public static void sendReturn(WebElement webUI) throws InterruptedException {
		webUI.sendKeys(Keys.RETURN);
		Thread.sleep(1000);
	}
	
	public static String getText(WebElement webUI){
		return webUI.getText();
	}
	
	public static boolean verifyElementDisplayed(WebElement webUI) {
		return webUI.isDisplayed();
	}
	
	public static boolean validateURL(WebDriver driver, String expectedURL) {
	    String currentURL = driver.getCurrentUrl();
	    return currentURL.equals(expectedURL);
	}
	
	public static void clear(WebElement webUI) {
	    webUI.clear();
	}
	
	public static void clearAllText(WebElement webUI) throws InterruptedException {
		webUI.click();
		Thread.sleep(1000);
		webUI.sendKeys(Keys.chord(Keys.COMMAND, "a"));
		Thread.sleep(1000);
	    webUI.clear();
	    Thread.sleep(1000);
	}
	
	public static void refreshPage(WebDriver driver) {
	    driver.navigate().refresh();
	}
	
	public static void waitForPageToLoad(WebDriver driver, Duration timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
	    wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
	}
	
	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
		File scrFile = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = "./test-output/ExecutionResultsInsuranceServices";
		
		try {
			FileHandler.createDir(new File (screenshotPath));
			FileHandler.copy(scrFile, new File(screenshotPath + File.separatorChar + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
