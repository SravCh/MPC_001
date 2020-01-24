package com.mpc.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mpc.qa.base.Testbase;
import com.mpc.qa.pages.Homepage;
import com.mpc.qa.pages.Loginpage;

public class LoginPageTest extends Testbase{
	Loginpage lp;
	Homepage hp;
	//Super keyword: Parentclass Constructor will be called
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		lp = new Loginpage();
	}
	
	@Test(priority = 1)
	public void LoginpageTitleTest()
	{
		String title = lp.validateloginpageTitle();
		Assert.assertEquals(title, "My Store");
	}
	
	@Test(priority = 2)
	public void LoginImageTest()
	{
		Boolean flag =  lp.validateImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void LoginTest()
	{
		hp = lp.login(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
