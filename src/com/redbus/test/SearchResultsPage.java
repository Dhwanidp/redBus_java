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
	
	
	private By trainCards = By.xpath("//div[contains(@class,'trainDetails')]");
    private By journeyClass = By.xpath("//span[contains(@class,'journeyClass')]");

    public void waitForResultsToLoad() {
    	presenceOfAllElementsLocated(trainCards);
        refreshedVisibilityOfAllElements(journeyClass);
    }

    public void waitForResultsAfterFilter() {
        refreshedVisibilityOfAllElements(journeyClass);
    }
			
	public void verifyResultsDisplayed() {

	    By trainResultCard = By.xpath("//div[contains(@class,'trainDetails')]");

	    Assert.assertTrue(isElementPresent(trainResultCard, 5),
	        "Train search results are not displayed"
	    );
	}
	
	 public void verifyTrainClassFilter(String classType) {
		 
		    waitForResultsToLoad();	     
		   
		 	By classButtonLocator = (By.xpath("//div[@id='1']//div[@role='button']"));
		    ToBeClickable(classButtonLocator);
		    WebElement classButton = driver.findElement(classButtonLocator);
		    classButton.click();
     	    		    
     		By classHeader = By.xpath("//div[contains(@class,'listHeader') and contains(normalize-space(),'" + classType + "')]");
     		refreshedToBeClickable(classHeader).click();
     		
		    waitForResultsAfterFilter();

			By classLocator = By.xpath("//div[contains(@class,'listHeader')]");
			presenceOfAllElementsLocated(classLocator);
			
			By trainClassLocator = By.xpath("//span[contains(@class,'journeyClass')]");
			refreshedVisibilityOfAllElements(trainClassLocator);

			List<WebElement> elements = driver.findElements(trainClassLocator);

			List<String> trainClasses = new ArrayList<>();

			for (WebElement el : elements) {
				
				trainClasses.add(el.getText());
			
				}
			
			Assert.assertTrue(trainClasses.contains(classType));
     }
	
		public void verifyErrorMessageIfPresent() {

		    By errorMsg = By.xpath("//*[contains(text(),'Something went wrong')]");

		    if (isElementPresent(errorMsg, 1)) {
		        Assert.fail("Search failed: 'Something went wrong' message displayed");
		    }
}

	
}
