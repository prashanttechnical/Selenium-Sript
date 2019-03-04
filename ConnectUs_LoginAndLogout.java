package com.connectus.webelementandmethods;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ConnectUs_LoginAndLogout 
{

	WebDriver driver;
	
	//Login page web elements
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	WebElement login_ID;	
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement pass;
	
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary btn-block btn-flat']")
	WebElement submit_button;
	
	//Logout web element
	@FindBy(how=How.XPATH,using="//span[@class='hidden-xs']")
	WebElement logout_link;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-danger btn-flat']")
	WebElement logout_button;
	
	@FindBy(how=How.XPATH,using="//button[@class='confirm']")
	WebElement logout_confirmation;
	
	@FindBy(how=How.XPATH,using="/html")
	WebElement escape;
	
	
	
	//constructor
	public void ConnectUs_Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Login method
	public void ConnectUsLoginApp(String strUser,String strPass)
	{
		login_ID.sendKeys(strUser);
		pass.sendKeys(strPass);
		
		String button=submit_button.getText();
		Assert.assertEquals("Sign In", button);
		submit_button.click();
		System.out.println("User successfully logged In.");
		
	}
	
	public void InvalidUsername(String struser,String strPass) throws Exception
	{
		login_ID.sendKeys(struser);
		pass.sendKeys(strPass);
		submit_button.click();
		Thread.sleep(2000);
		
	}
	
	public void InvalidPassword(String struser,String strPass) throws Exception
	{
		login_ID.clear();
		login_ID.sendKeys(struser);
		pass.sendKeys(strPass);
		submit_button.click();
		Thread.sleep(2000);
	}
	
	//Logout method
	public void ConnectUsLogoutApp() throws Exception
	{
		logout_link.click();
		Thread.sleep(1000);
		logout_button.click();
		Thread.sleep(1000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		logout_confirmation.click();
		System.out.println("User successfully logged out.");

	}
}
