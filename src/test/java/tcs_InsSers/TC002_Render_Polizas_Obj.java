package tcs_InsSers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods_InsSers.CommonActions_InsSers;
import commonMethods_InsSers.GlobalVariables_InsSers;
import pages_InsSers.MisPolizasPage_InsSers;
import pages_InsSers.LoginPage_InsSers;
import setupDriver_InsSers.SetupDriver_InsSers;

public class TC002_Render_Polizas_Obj {

	WebDriver driver = SetupDriver_InsSers.setupDriverMethod();

	LoginPage_InsSers loginPageInsSers = new LoginPage_InsSers(driver);
	MisPolizasPage_InsSers polizasPage = new MisPolizasPage_InsSers(driver);

	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables_InsSers.LOGIN_PAGE);
	}

	@Test
	public void TC002() throws InterruptedException {
		loginPageInsSers.loginAccount(GlobalVariables_InsSers.PASSWORD);
		
		Thread.sleep(2000);
		polizasPage.verPoliza1st();

	}
	
	   @AfterTest   
	    public void closeDriver() {
	    	
	    	// Otros pasos de cierre si es necesario
	        
	        try {
	            // Pausa de 1 segundos (1000 milisegundos)
	            Thread.sleep(1000);
	            System.out.println("Test - espara 1sec final test..");
	            CommonActions_InsSers.takeScreenshot(driver, "TC002-001_Render_1st_poliza");
	        } catch (InterruptedException e) {
	            // Manejar cualquier excepción que pueda ocurrir al pausar el hilo
	            e.printStackTrace();
	        }

	        // Cierra el navegador
	  	  	driver.quit();
	    }
}
