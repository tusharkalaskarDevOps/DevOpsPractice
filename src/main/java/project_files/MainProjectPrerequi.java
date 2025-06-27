package project_files;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import utilitis.ExcelUtils;

public class MainProjectPrerequi {
	public static WebDriver driver;
	public static String baseUrl;
	public static String fileName;
	public static String sheetName;
	
	@BeforeClass
	public WebDriver setUpDriver() {
		
		Properties p =  new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\2407425\\eclipse-workspace\\final_mini_project\\src\\main\\resources\\config.properties");
			p.load(fis);
		}catch(Exception e) {
			
		}
		baseUrl = p.getProperty("url");
		fileName = p.getProperty("file");
		sheetName = p.getProperty("sheet");
		
		driver = DriverSetup.getDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod
	public void clickCreateNewAccount() {
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
	}
	
	@DataProvider(name = "getValidData")
	public String[][] getUserDate(){
		String[][] userData = ExcelUtils.signUpData(fileName, sheetName);
		return userData;
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
