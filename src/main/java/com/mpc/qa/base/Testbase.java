package com.mpc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mpc.qa.util.TestUtil;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase()
	{
		try {
		prop  = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/mpc/qa/config/config.properties");
		prop.load(ip);
		}
		catch (FileNotFoundException e)
		{e.printStackTrace();
		}
		catch (IOException e)
		{e.printStackTrace();
		}
	}
	
	public static void intialization() {
		String browsername = prop.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:/Users/srava/Downloads/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}


