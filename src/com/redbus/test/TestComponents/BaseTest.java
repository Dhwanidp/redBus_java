package com.redbus.test.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.redbus.test.LandingPage;

public class BaseTest {

	   WebDriver driver;
	   
	   @BeforeMethod
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
	    
	    public File getScreenshot(String testCaseName) throws IOException {
	    	
	    	TakesScreenshot ss = (TakesScreenshot)driver;
	    	File source = ss.getScreenshotAs(OutputType.FILE);
	    	File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
	    	FileUtils.copyFile(source, file);
	    	return file;
	    }
	    
	    @AfterMethod
	    public void AfterExecu() {
	    		driver.quit();
			}
		}

	
