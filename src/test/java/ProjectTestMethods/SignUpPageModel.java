package ProjectTestMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPageModel {
	public static WebDriver driver;

	public SignUpPageModel(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Locaters for the WebElements
	@FindBy(xpath="//input[@type='text' and @class='inputtext _58mg _5dba _2ph-' and @name='firstname']") WebElement firstName_loc;
	@FindBy(xpath="//input[@type='text' and @class='inputtext _58mg _5dba _2ph-' and @name='lastname']") WebElement lastname_loc;
	@FindBy(xpath="//input[@type='text' and @class='inputtext _58mg _5dba _2ph-' and @name='reg_email__']") WebElement email_loc;
	@FindBy(xpath="//*[@id='day']") WebElement days_loc;
	@FindBy(xpath="//*[@id='month']") WebElement months_loc;
	@FindBy(xpath="//*[@id='year']") WebElement years_loc;
	
	@FindBy(xpath="//*[@name='websubmit' and text()='Sign Up']") WebElement subBtn_loc;
	@FindBy(xpath="//div[@id='globalContainer']/div[3]/div/div/div") WebElement passErrorBlock_loc;
	@FindBy(xpath="//div[@id='globalContainer']/div[4]/div/div/div") WebElement numberErrorBlock_loc;
	
//	@FindBy(xpath="//*[@id='sex' and @value='\"+value+\"']") WebElement sex_loc;
	
	
	//Set Methods that will be call from Test Methods
	public void setFirstName(String firstname) {
		firstName_loc.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		lastname_loc.sendKeys(lastname);
	}
	public void setEmail(String email) {
		email_loc.sendKeys(email);
	}
	public void setDate(String day, String month, String year) {
		
		Select days =new  Select(days_loc);
		days.selectByVisibleText(day);
		
		//locate and pass month
		int mon = (int)Double.parseDouble(month);
		Select months =new  Select(months_loc);
		months.selectByIndex(mon-1);
		
		//locate and pass year
		Select years =new  Select(years_loc);
		years.selectByValue(year);
		
	}
	public void setGender(String sex) {
		
		int value;
		if(sex.equalsIgnoreCase("Male")) {
			value =2;
		}else if(sex.equalsIgnoreCase("Female")) {
			value =1;
		}else {
			value=3;
		}
		
		driver.findElement(By.xpath("//*[@id='sex' and @value='"+value+"']")).click();
	}
	public void clickSubBtn() {
		subBtn_loc.click();
	}
	public String getPassErrorMsg() {
		return passErrorBlock_loc.getText();
	}
	public String getNumErrorMsg() {
		return numberErrorBlock_loc.getText();
	}
	public void setSignUpData(String firstname,  String lastname, String email, String day, String month, String year,  String sex) {
		setFirstName(firstname);
		setLastName( lastname);
		
		setDate( day,  month,  year);
		setGender(sex);
		setEmail(email);
	}
	
	
	
}
