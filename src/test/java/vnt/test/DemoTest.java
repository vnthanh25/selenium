package vnt.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import vnt.test.environment.EnvironmentManager;
import vnt.test.environment.RunEnvironment;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemoTest {

	@BeforeClass
    public static void startBrowser() {
        EnvironmentManager.initWebDriver();
    }

    @Test
    public void demo() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("https://www.blazemeter.com/selenium");
        String homeUrl = driver.findElement(By.cssSelector("div#logo> a#logo_image ")).getAttribute("href");
        assertEquals(homeUrl, "https://www.blazemeter.com/");
    }

    @AfterClass
    public static void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
