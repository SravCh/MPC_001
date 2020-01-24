package com.mpc.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mpc.qa.base.Testbase;

public class Loginpage extends Testbase {
	
	//Pagefactory = OR (object Repository)
	
	@FindBy(name = "email") WebElement EmailID;
	
	@FindBy(name ="passwd") WebElement Password;
	
	@FindBy(id = "SubmitLogin") WebElement Login;
	
	@FindBy(linkText = "Sign in") WebElement SignIn;
	
	@FindBy(id ="SubmitCreate") WebElement CreateanAccount;
	
	@FindBy(xpath = "//img[contains (@class, 'logo img-responsive')]") WebElement Logo;
	
	//Intializing the Page Objects
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginpageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateImage()
	{
		return Logo.isDisplayed();
	}
	
	public Homepage login(String email, String pwd)
	{
		SignIn.click();
		EmailID.sendKeys(email);
		Password.sendKeys(pwd);
		Login.click();
		return new Homepage();
	}
}
