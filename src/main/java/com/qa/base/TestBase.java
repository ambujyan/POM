package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String nodeUrl;
	
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

	public static void initialization(String portNo, String appUrl) throws MalformedURLException {
	
		if(portNo.equalsIgnoreCase("4445")) {
			
			nodeUrl = "http://172.20.1.21:4445/wd/hub";
			System.out.println("Chrome Browser Test Environment Created");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			//Define Chrome Options
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
			driver = new RemoteWebDriver(new URL(nodeUrl), cap);
			driver.manage().window().maximize();
			driver.navigate().to(appUrl);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 
			
		}
		else if(portNo.equalsIgnoreCase("4446")) {
			
			nodeUrl = "http://172.20.1.21:4446/wd/hub";
			System.out.println("Firefox Browser Test Environment Created");
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
			cap.setVersion("38.0.5");
			cap.setCapability("marionette", false);
			
			ChromeOptions options = new ChromeOptions();
			options.merge(cap);
			
			//DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL(nodeUrl), cap);
			driver.manage().window().maximize();
			driver.navigate().to(appUrl);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
		else
		{
			System.err.println("Provide correct port no");
		}
		
	
	}
}

/*	public static void initialization(String browser) {

// String browserName = prop.getProperty("browser");
			
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
		//localhost/0:0:0:0:0:0:0:1:13985
		 //setUp("http://my.local.host:5555/", "*firefox");
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
	
	
}
*/	
