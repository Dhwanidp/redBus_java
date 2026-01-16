package com.redbus.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class redbus {

    WebDriver driver;
    WebDriverWait wait;
    
	@BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/railways");
    }
    
    @Test
    public void TrainSerach() {
    		
    		String from = "Delhi";
    		String to = "Pune";

    		driver.findElement(By.xpath("//div[contains(@class,'label_')]")).click();
    		WebElement input = driver.switchTo().activeElement();
    		input.sendKeys(from);
    		driver.findElement(By.xpath("//div[contains(@class,'listHeader') and contains(text(),'"+ from +"')]")).click();
		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Popular City & stations')]")));
    		WebElement input2 = driver.switchTo().activeElement();
    		input2.sendKeys(to);
    		driver.findElement(By.xpath("(//div[contains(@class,'listHeader') and contains(text(),'"+ to +"')])[2]")).click();
		
    		String targetMonth = "February 2026";
    		String targetDay = "15";
    		String monthXpath = "//p[contains(@class,'monthYear')]";
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(monthXpath)));		
    		while (!driver.findElement(By.xpath(monthXpath)).getText().equals(targetMonth)) {
    		    driver.findElement(By.xpath("//i[contains(@class,'icon-arrow')][2]")).click();
    		}
    		driver.findElement(By.xpath("//li/div/div/span[text()='" + targetDay + "']")).click();

    }
    
    @Test(dependsOnMethods = "TrainSerach")	
    public void FreeCancelCharge() {

        	String FreeCancelation = "Yes";
        	if (FreeCancelation.contains("Yes")) {
			driver.findElement(By.id("switch")).click();
			driver.findElement(By.xpath("//button[contains(@class, 'searchButtonWrapper')]")).click();
		}
    }
    
    @Test(dependsOnMethods = "FreeCancelCharge")
    public void TrainClass() {

        	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='1']//div[@role='button']")));
        	button.click();			
        	String classType = "2A"; 
        	By classHeader = By.xpath("//div[contains(@class,'listHeader') and contains(normalize-space(),'" + classType + "')]");

			WebElement classElement = wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(classHeader)));
			classElement.click();			
			
			By classLocator = By.xpath("//div[contains(@class,'listHeader')]");
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(classLocator));
			By trainClassLocator = By.xpath("//span[contains(@class,'journeyClass')]");

			List<String> trainClasses = new ArrayList<>();
			int count = driver.findElements(trainClassLocator).size();
			for (int i = 0; i < count; i++) {
	        String classOfTrain = driver.findElements(trainClassLocator).get(i).getText();
	        trainClasses.add(classOfTrain);
			}
			Assert.assertTrue(trainClasses.contains(classType));
        }
       
    @AfterSuite
    public void AfterExecu() {
    		driver.quit();
		}
	}
