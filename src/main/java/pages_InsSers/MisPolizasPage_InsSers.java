package pages_InsSers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods_InsSers.CommonActions_InsSers;
//import commonMethods_InsSers.GlobalVariables_InsSers;


public class MisPolizasPage_InsSers {
	
	public MisPolizasPage_InsSers (WebDriver driver) {
		PageFactory.initElements(driver, this);
		System.out.println("MisPolizasPage_InsSers - Mis polizas Page ha inicializado el chrome driver..");
	}
	
	@FindBy (xpath = "//*[@id=\"__next\"]/div/div[1]/div/div[1]/div/div/div[2]/div[4]") private WebElement cerrarSesionBtn;
	@FindBy (xpath = "//*[@id=\"radix-:ri:\"]/div/div/div/div[2]/div/button/button") private WebElement verDetBtn;
	
	
	
	public void logoutAccount() throws InterruptedException {
		CommonActions_InsSers.click(cerrarSesionBtn);
//		Thread.sleep(1000);
		System.out.println("MisPolizasPage: logoutAccount..");
		}
	
	public void verDet() throws InterruptedException {
		CommonActions_InsSers.click(verDetBtn);
//		Thread.sleep(1000);
		System.out.println("MisPolizasPage: logoutAccount..");
		}



}
