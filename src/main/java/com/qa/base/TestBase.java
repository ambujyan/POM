package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	//public static String nodeUrl;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java"+"/com/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	public static void initialization() {

	String browser = prop.getProperty("browser");
			
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/resources/java/chromedriver.exe");
		driver = new ChromeDriver();
		//Log.info("Chrome browser launched");
		
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/resources/java/geckodriver.exe");
		
		
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites = DesiredCapabilities.firefox();
		capabilites.setBrowserName("firefox");
		capabilites.setVersion("38.0.5");
		capabilites.setPlatform(Platform.WINDOWS);
		capabilites.setCapability("marionette", false);
		
		//DesiredCapabilities.firefox();
		driver = new FirefoxDriver(capabilites);
		FirefoxOptions options = new FirefoxOptions();
	     options.addArguments("--headless");
	     driver =  new FirefoxDriver(options);
	     	
	}
	
	else if(browser.equalsIgnoreCase("IE")){
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/src/resources/java/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability("requireWindowFocus", true);  
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
		capabilities.setCapability("ie.ensureCleanSession", true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
		//capabilities.setBrowserName("internet explorer");
		//capabilities.setVersion("11.192.16299.0");
		capabilities.setPlatform(Platform.WINDOWS);
		driver = new InternetExplorerDriver(capabilities);
				
		
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	//Log.info("URL launched");
	
	
}}
	
