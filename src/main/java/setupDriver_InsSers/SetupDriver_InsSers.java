package setupDriver_InsSers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupDriver_InsSers {
	
	public static WebDriver setupDriverMethod() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("SetupDriver - Se inicia una sesión del chrome, si no carga espera 10 segundos..");
		return driver;		
	}

}
