package com.redbus.test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class E2E_Test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void redBusEndToEndTest() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.TrainSearch("Delhi", "Pune");
        landingPage.Calender("February 2026", "15");
        landingPage.FreeCancelCharge("Yes");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.TrainClass("SL");
    }

	    
	 	@AfterSuite
	    public void AfterExecu() {
	    		driver.quit();
			}
		}

