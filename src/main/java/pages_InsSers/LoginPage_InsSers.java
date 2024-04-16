package pages_InsSers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods_InsSers.CommonActions_InsSers;
import commonMethods_InsSers.GlobalVariables_InsSers;

public class LoginPage_InsSers {
	
	public LoginPage_InsSers (WebDriver driver) {
		PageFactory.initElements(driver, this);
		System.out.println("MisPolizasPage_InsSers - Mis Polizas Page ha inicializado el chrome driver..");
	}
	
	@FindBy(id = ":r0:-form-item") private WebElement emailTxtBox;
	@FindBy(id = ":r1:-form-item") private WebElement passTxtBox;
	@FindBy(css = "[type='submit']") private WebElement accessBtn;
	@FindBy(css = "[type='button']") private WebElement recuperarAccesoBtn;
	
	@FindBy(id = "::r8:-form-item") private WebElement emailRecupAccsTxtBox;

	@FindBy (xpath = "//*[@id=\"__next\"]/div/div[2]/ol/li/div/div[2]") private WebElement wrongPassTxt;
	
	
	public void loginAccount(String password) throws InterruptedException {
//		Thread.sleep(1000);
		CommonActions_InsSers.sendKeys(emailTxtBox, GlobalVariables_InsSers.USER);
//		Thread.sleep(1000);
		CommonActions_InsSers.sendKeys(passTxtBox, password);
//		Thread.sleep(1000);
		CommonActions_InsSers.click(accessBtn);
//		Thread.sleep(1000);
		System.out.println("LoginPage: loginAccount..");
		Thread.sleep(3000);
		}

	
	public boolean validateWrongPassMessage() {
		boolean errorDisplayed = CommonActions_InsSers.getText(wrongPassTxt).contains("El correo electrónico o contraseña son inválidos");
		System.out.println("LoginPage: validateWrongPassMessage..");
		return errorDisplayed;
	}
	
	public void resetPassword() throws InterruptedException {

		// aquí van las acciones para resetear el password
		}



}
