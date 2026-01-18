package com.redbus.test;

import java.io.IOException;
import org.testng.annotations.Test;

import com.redbus.test.TestComponents.BaseTest;


public class E2E_Test extends BaseTest{

 

    @Test
    public void redBusEndToEndTest() throws IOException{

        LandingPage landingPage = launchApplication();
        landingPage.searchTrains("Delhi", "Pune");
        landingPage.selectDate("February 2026", "15");
        SearchResultsPage resultsPage = landingPage.applyFreeCancellationAndSearch("Yes");

        resultsPage.TrainClass("SL");
    }

	    
}
