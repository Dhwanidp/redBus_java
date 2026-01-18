package com.redbus.test.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.redbus.test.LandingPage;

public class BaseTest {

	   WebDriver driver;
	   
	   @BeforeSuite
	    public WebDriver setUp() throws IOException {
	    	
	    	Properties prop = new Properties();
	    	FileInputStream file = new FileInputStream((System.getProperty("user.dir")+"\\src\\com\\redbus\\test\\resources\\GlobalData.properties"));
	    	prop.load(file);
	    	String browserName = prop.getProperty("browser");
	    	if(browserName.equalsIgnoreCase("Chrome")) {
	    		
		        driver = new ChromeDriver();
		        
	    	}
	    	
	    	else if(browserName.equalsIgnoreCase("edge")) {
	    		
	    		driver = new EdgeDriver();
	    	}
	    	
	    	else if(browserName.equalsIgnoreCase("Firefox")) {
	    		
	    		driver = new FirefoxDriver();
	    	}
	    	
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        return driver;
	    }
	    
	    
	    public LandingPage launchApplication() throws IOException {
	    	
	    	LandingPage landingPage = new LandingPage(driver);
	        landingPage.goTo();
	    	return landingPage;

	    }
	    
	    @AfterSuite
	    public void AfterExecu() {
	    		driver.quit();
			}
		}

