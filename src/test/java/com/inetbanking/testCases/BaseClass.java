package com.inetbanking.testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rc = new ReadConfig();
	public static WebDriver driver; 
	public static Logger logger;
	public String baseUrl = rc.getUrl();
	public String username = rc.getUsername();
	public String password = rc.getPassword();
	public String pgTile = "GTPL Bank Manager HomePage";
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
	    
		logger = Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			WebDriverManager.firefoxdriver().browserVersion("0.9").setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
	}
	
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	
	
}
