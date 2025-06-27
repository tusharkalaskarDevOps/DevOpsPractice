package project_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
    
		if(driver == null) {
			driver = new ChromeDriver();
		}
		
		
		return driver;
		
	}
}
