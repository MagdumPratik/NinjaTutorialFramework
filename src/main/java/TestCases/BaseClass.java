package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import Utils.ReadConfigPropertyFile;
import Utils.Reporting;
import Utils.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfigPropertyFile rd=new ReadConfigPropertyFile();
	XLUtils xl=new XLUtils();
	Reporting rp=new Reporting();
	public  String baseURLBS=rd.getURL();
	public  String EmailBS=rd.getUser();
	public  String passwordBS=rd.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger=logger.getLogger("tutueialNinja");
		PropertyConfigurator.configure("log4j.properties");				
		
	}
	
	@AfterTest
	public void tearup()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String name) throws IOException
	{
		String fileName=generateFileName();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(fileName));
		System.out.println("Screenshot taken SuccessFully");
	}
	  public static String generateFileName(){
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        LocalDateTime now = LocalDateTime.now();
	        String currentDirectory = System.getProperty("user.dir");
	        String filePath = currentDirectory + "\\Screenshots\\";
	        String fileName = filePath + dtf.format(now) + ".png";
	        return fileName;
	    }

}
