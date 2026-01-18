package com.redbus.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.redbus.test.util.AbstractComponents;

public class LandingPage extends AbstractComponents  {
	
			WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	
	public void goTo() {
    	
        driver.get("https://www.redbus.in/railways");

	}
	 	
    public void searchTrains(String from, String to ) { 
    		
    		WebElement fromBtn =  driver.findElement(By.xpath( "//div[contains(@class,'label_')]"));
    		fromBtn.click();
    		
    		WebElement input = driver.switchTo().activeElement();
    		input.sendKeys(from);
    		
    		WebElement fromSelect = driver.findElement(By.xpath("//div[contains(@class,'listHeader') and contains(text(),'"+ from +"')]"));
    		fromSelect.click();
		
    		waitForElementToAppear(By.xpath("//h2[contains(text(),'Popular City & stations')]"));
    		
    		WebElement input2 = driver.switchTo().activeElement();
    		input2.sendKeys(to);
    		
    		WebElement toSelect = driver.findElement(By.xpath("(//div[contains(@class,'listHeader') and contains(text(),'"+ to +"')])[2]"));
    		toSelect.click();
    				}
    
    public void selectDate(String targetMonth, String targetDay) {

        By monthLocator = By.xpath("//p[contains(@class,'monthYear')]");
        By arrowLocator = By.xpath("//i[contains(@class,'icon-arrow')][2]");
        By dateLocator  = By.xpath("//li/div/div/span[text()='" + targetDay + "']");

        waitForElementToAppear(monthLocator);

        while (!driver.findElement(monthLocator).getText().equals(targetMonth)) {
            driver.findElement(arrowLocator).click();
            waitForElementToAppear(monthLocator);
        }

        waitForElementToAppear(dateLocator);
        driver.findElement(dateLocator).click();
    }
    
    public SearchResultsPage applyFreeCancellationAndSearch(String option) {

        WebElement cancelBtn = driver.findElement(By.id("switch"));
        WebElement searchBtn = driver.findElement(
            By.xpath("//button[contains(@class, 'searchButtonWrapper')]")
        );

        if (option.equalsIgnoreCase("Yes")) {
            cancelBtn.click();
        }

        searchBtn.click();
        return new SearchResultsPage(driver);

    }
	
	
}