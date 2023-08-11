package TestCases;

import org.testng.annotations.Test;

import PageObjects.LoginPageObject;

public class TC_LoginTest001 extends BaseClass{

	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURLBS);
		logger.info("Chrome opened and also URL is opened");
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setEmail(EmailBS);
		logger.info("Email is set");
		lp.setPassword(passwordBS);
		logger.info("Password is set");
		lp.clickLogin();
		Thread.sleep(3000);
		logger.info("Test Case Passed");
		
	}
	
}
