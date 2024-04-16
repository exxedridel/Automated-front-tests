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
		CommonActions_InsSers.takeScreenshot(driver, "TCSS-003_Render_polizas");
		
		Thread.sleep(5000);
		polizasPage.verDet();

//		if (CommonActions_InsSers.validateURL(driver, GlobalVariables_InsSers.POLIZAS_PAGE)) {
//			System.out.println("La URL de polizas es correcta.");
//			Assert.assertTrue(true, "La URL es correcta.");
//		} else {
//			System.out.println("La URL de polizas es incorrecta.");
//			Assert.fail("La URL es incorrecta.");
//		}
//
//		polizasPage.logoutAccount();
//
//		loginPageInsSers.loginAccount(GlobalVariables_InsSers.WRONGPASS);
//		boolean wrongPassText = loginPageInsSers.validateWrongPassMessage();
//		Assert.assertTrue(wrongPassText, "mensaje de error en password mostrado correctamente");
	}
}
