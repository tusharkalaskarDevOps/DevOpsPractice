package ProjectTestMethods;

import org.testng.annotations.Test;

import project_files.MainProjectPrerequi;

public class TestProject extends MainProjectPrerequi{
	
	@Test(dataProvider = "getValidData")
	public void testSignUp(String firstname, String lastname, String email, String day, String month, String year,  String sex, String passw) throws InterruptedException {
		System.out.println("Test is start.......");
		SignUpPageModel SPM = new SignUpPageModel(driver);
		SPM.setSignUpData(firstname, lastname, email, day, month, year, sex);
		SPM.clickSubBtn();
		String error1 = SPM.getPassErrorMsg();
		Thread.sleep(3000);
		SPM.clickSubBtn();
		String error2 = SPM.getNumErrorMsg();
		
		System.out.println(error1);
		System.out.println(error2);
		
		System.out.println("Test is done.......");
	}
}
