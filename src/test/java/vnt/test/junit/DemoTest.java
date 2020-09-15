package vnt.test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import vnt.test.config.WebDriverConfig;

public class DemoTest {
	private static WebDriver driver;

	@BeforeClass
    public static void startBrowser() {
		driver = WebDriverConfig.getWebDriver(null);
    }

    @AfterClass
    public static void tearDown() {
    	driver.close();
    }

    @Test
    public void demo() {
        driver.get("https://www.google.com.vn");
        String homeUrl = driver.findElement(By.cssSelector("img#hplogo")).getAttribute("src");
        assertEquals(homeUrl, "https://www.google.com.vn/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
    }
}
