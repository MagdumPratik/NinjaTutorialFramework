package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPageObject;

public class TC_DATLoginTest extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginTest(String em, String pas) throws InterruptedException, IOException
	{
		driver.get(baseURLBS);
		LoginPageObject lp=new LoginPageObject(driver);
		lp.setEmail(em);
		Thread.sleep(3000);
		logger.info("Email is PRovided");
		lp.setPassword(pas);
		Thread.sleep(3000);
		logger.info("Password is Provided");
		lp.clickLogin();
		
		if(lp.getMsg().equals("My Account"))
		{
			logger.info("Test Case PAssed");
			Assert.assertTrue(true);
			lp.clicklogout();
			Thread.sleep(2000);
			lp.clickAgainLogin();
			Thread.sleep(2000);
		}
		else
		{
			logger.info("Test Case Failed");
			captureScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
			driver.navigate().refresh();
			driver.switchTo().defaultContent();
			
		}
	}
	

	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String ExcelFilePath=System.getProperty("user.dir") + "\\LoginData.xlsx\\";

		int rownum=xl.getRowCount(ExcelFilePath, "Sheet1");
		int colcount=xl.getCellCount(ExcelFilePath, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			
			for(int c=0;c<colcount;c++)
			{
				logindata[i-1][c]=xl.getCellData(ExcelFilePath, "Sheet1", i, c);
				
			}
		}
		return logindata;
	}
}
