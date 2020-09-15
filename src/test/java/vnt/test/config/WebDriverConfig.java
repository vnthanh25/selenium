package vnt.test.config;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vnt.test.environment.PropertyManager;

public class WebDriverConfig {

	private static WebDriver chromWebDriver;

	public static WebDriver getWebDriver(String webDriverName) {
		PropertyManager propertyManager = PropertyManager.getInstance();
		if (chromWebDriver == null) {
			System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("").getPath()
					+ propertyManager.getProperty("webdriver.file.path"));
			if (StringUtils.isEmpty(webDriverName)) {
				chromWebDriver = new ChromeDriver();
			}
		}
		// return.
		return chromWebDriver;
	}

}
