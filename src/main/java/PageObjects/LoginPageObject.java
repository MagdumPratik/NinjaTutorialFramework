package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	WebDriver ldriver;
	public LoginPageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement clickLogin;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clickLogOut;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']")
	WebElement clickloginagain;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAc;
	
	
	public void setEmail(String ema)
	{
		email.sendKeys(ema);
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		clickLogin.click();
	}
	public void clicklogout()
	{
		clickLogOut.click();
	}
	public void clickAgainLogin()
	{
		clickloginagain.click();
	}
	public String getMsg() {
	String msg=myAc.getText();
	return msg;
}
}