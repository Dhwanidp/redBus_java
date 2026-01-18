package com.redbus.test;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.redbus.test.util.AbstractComponents;

public class SearchResultsPage extends AbstractComponents  {
	
	WebDriver driver;

	public SearchResultsPage(WebDriver driver){
		
			super(driver);
			this.driver = driver;
		}
	
	
	 public void TrainClass(String classType) {

		 	By classButtonLocator = (By.xpath("//div[@id='1']//div[@role='button']"));
		    ToBeClickable(classButtonLocator);
		    WebElement classButton = driver.findElement(classButtonLocator);
		    classButton.click();
     	     	
     		By classHeader = By.xpath("//div[contains(@class,'listHeader') and contains(normalize-space(),'" + classType + "')]");
     		refreshedToBeClickable(classHeader);
     		
     		WebElement classElement = driver.findElement(classHeader);
			classElement.click();			
			
			By classLocator = By.xpath("//div[contains(@class,'listHeader')]");
			presenceOfAllElementsLocated(classLocator);
			
			By trainClassLocator = By.xpath("//span[contains(@class,'journeyClass')]");
			List<String> trainClasses = new ArrayList<>();
			int count = driver.findElements(trainClassLocator).size();
			for (int i = 0; i < count; i++) {
	        String classOfTrain = driver.findElements(trainClassLocator).get(i).getText();
	        trainClasses.add(classOfTrain);
				}
			
			Assert.assertTrue(trainClasses.contains(classType));
     }
	
	
	
}
