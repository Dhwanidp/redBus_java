package com.redbus.test.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	
	 WebDriver driver;
	 WebDriverWait wait;

	public AbstractComponents(WebDriver driver) {
		
			this.driver= driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebElement waitForElementToAppear(By locator) {
		
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void presenceOfAllElementsLocated(By locator) {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public WebElement refreshedToBeClickable(By locator) {
	    return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
	}
	public void ToBeClickable(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void refreshedVisibilityOfAllElements(By locator) {
		
	    wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)));
	}

	public boolean isElementPresent(By locator, int timeoutSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
}
