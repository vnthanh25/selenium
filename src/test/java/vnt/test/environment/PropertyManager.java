package vnt.test.environment;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Manages the application configuration from some resource files.
 */
public class PropertyManager {

	// Lazy singleton.
	private static class PropertyManagerInstance {
		private static final PropertyManager instance = new PropertyManager();
	}

	// Singleton.
	public static PropertyManager getInstance() {
		return PropertyManagerInstance.instance;
	}

	// Application properties.
	private Properties properties;

	/**
	 * Loads properties from resource file and put to system.
	 */
	public PropertyManager() {
		// Create properties instance.
		this.properties = new Properties();
		// Load application properties file.
		this.loadPropeties();
	}

	/**
	 * Load properties from a file named 'application.properties' or
	 * 'application.yml'.
	 */
	private void loadPropeties() {
		try {
			String resourceAbsolutePath = this.getClass().getClassLoader().getResource("").getPath();
			File applicationFile = new File(resourceAbsolutePath + "application.properties");
			if (!applicationFile.exists()) {
				applicationFile = new File(resourceAbsolutePath + "application.yml");
			}
			FileInputStream fis = new FileInputStream(applicationFile);
			properties.load(fis);
		} catch (Exception ex) {
			System.out.println("The application properties file cannot be found.");
		}
	}

	/**
	 * Get property value by property key from the application properties file.
	 * 
	 * @param propertyKey
	 * @return
	 */
	public String getProperty(String propertyKey) {
		return properties.getProperty(propertyKey);
	}

}
