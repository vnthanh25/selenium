package vnt.test.testng;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import vnt.test.config.WebDriverConfig;

public class DemoTest {
	private static WebDriver driver;

	@BeforeSuite
    public void startBrowser() {
		driver = WebDriverConfig.getWebDriver(null);
    }

    @AfterSuite
    public void tearDown() {
    	driver.close();
    }
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

    @Test(testName = "demo")
    public void demo() {
        driver.get("https://www.google.com.vn");
        String homeUrl = driver.findElement(By.cssSelector("img#hplogo")).getAttribute("src");
        assertEquals(homeUrl, "https://www.google.com.vn/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
    }

    @Test(testName = "demo1")
    public void demo1() {
        driver.get("https://www.google.com.vn");
        String homeUrl = driver.findElement(By.cssSelector("img#hplogo")).getAttribute("src");
        assertEquals(homeUrl, "https://www.google.com.vn/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
    }
    
}
