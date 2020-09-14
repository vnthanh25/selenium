package vnt.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	
	private static WebDriver webDriver;
	private WebElement webElement;
	
	@BeforeClass
	public static void openBrowser() {
		System.out.println("openBrowser");
    	System.setProperty("webdriver.chrome.driver",  "D:\\Java\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void testWebSite() {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		webDriver.get("https://www.5balloons.info");
		Assert.assertEquals("5 Balloons – Practical Programming & Tech Articles", webDriver.getTitle());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@AfterClass
	public static void closeBrowser() {
		System.out.println("closeBrowser");
	}

}
