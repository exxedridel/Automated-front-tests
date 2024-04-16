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


public class TC001_Verify_Authentication {
	
	// Declarar e inicializar el WebDriver
	WebDriver driver = SetupDriver_InsSers.setupDriverMethod();	
	
	// Page Objects
	LoginPage_InsSers loginPageInsSers = new LoginPage_InsSers(driver);
	// this one not working yet, needs to update the element id
	MisPolizasPage_InsSers polizasPage = new MisPolizasPage_InsSers(driver);
	
	
	@BeforeTest
	public void startWebDriver() {
		driver.get(GlobalVariables_InsSers.LOGIN_PAGE);
	}	
	
    @Test
    public void TC001() throws InterruptedException {
    	loginPageInsSers.loginAccount(GlobalVariables_InsSers.PASSWORD);
    	CommonActions_InsSers.takeScreenshot(driver, "TC001-SS01_login_successfuly");
    	
    	if (CommonActions_InsSers.validateURL(driver, GlobalVariables_InsSers.POLIZAS_PAGE)) {
    	    System.out.println("La URL de polizas es correcta.");
    	    Assert.assertTrue(true, "La URL es correcta.");
    		} else {
    			System.out.println("La URL de polizas es incorrecta.");
    			Assert.fail("La URL es incorrecta.");
    		}
    	
    	polizasPage.logoutAccount();
    	
    	loginPageInsSers.loginAccount(GlobalVariables_InsSers.WRONGPASS);
    	boolean wrongPassText = loginPageInsSers.validateWrongPassMessage();
    	Assert.assertTrue(wrongPassText, "mensaje de error en password mostrado correctamente");   
  	    }
  	    	
    
    @AfterTest   
    public void closeDriver() {
    	
    	// Otros pasos de cierre si es necesario
        
        try {
            // Pausa de 1 segundos (1000 milisegundos)
            Thread.sleep(1000);
            System.out.println("Test - espara 1sec final test..");
            CommonActions_InsSers.takeScreenshot(driver, "TC001-SS02_Wrong_password");
        } catch (InterruptedException e) {
            // Manejar cualquier excepción que pueda ocurrir al pausar el hilo
            e.printStackTrace();
        }

        // Cierra el navegador
  	  	driver.quit();
    }
}


