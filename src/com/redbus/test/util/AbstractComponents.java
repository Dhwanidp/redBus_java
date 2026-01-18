package com.redbus.test.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	
	 WebDriver driver;
	 WebDriverWait wait;

	public AbstractComponents(WebDriver driver) {
		
			this.driver= driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void waitForElementToAppear(By locator) {
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void presenceOfAllElementsLocated(By locator) {
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void refreshedToBeClickable(By locator) {
		
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
		
	}
	public void ToBeClickable(By locator) {
		
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	
	
	
	
}
