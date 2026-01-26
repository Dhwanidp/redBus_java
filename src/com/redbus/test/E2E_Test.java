package com.redbus.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.redbus.test.TestComponents.BaseTest;
import com.redbus.test.data.DataReader;


public class E2E_Test extends BaseTest {

    @Test(dataProvider = "getData", groups = {"smoke", "regression_core"})
    public void redBusBasicSearchTest(HashMap<String, String> input) throws IOException {

        LandingPage landingPage = launchApplication();

        landingPage.searchTrains(input.get("from"), input.get("to"));
        landingPage.selectDate(input.get("month"), input.get("day"));

        SearchResultsPage resultsPage = landingPage.clickSearch();
        resultsPage.verifyResultsDisplayed();
    }

    @Test(dataProvider = "getData", groups = "regression_filter")
    public void verifyFreeCancellationFilter(HashMap<String, String> input) throws IOException {

        LandingPage landingPage = launchApplication();

        landingPage.searchTrains(input.get("from"), input.get("to"));
        landingPage.selectDate(input.get("month"), input.get("day"));

        landingPage.applyFreeCancellationFilter(input.get("freeCancel"));
        SearchResultsPage resultsPage = landingPage.clickSearch();

        resultsPage.verifyResultsDisplayed();
    }

    @Test(dataProvider = "getData", groups = "regression_filter")
    public void verifyTrainClassFilter(HashMap<String, String> input) throws IOException {

        LandingPage landingPage = launchApplication();

        landingPage.searchTrains(input.get("from"), input.get("to"));
        landingPage.selectDate(input.get("month"), input.get("day"));

        SearchResultsPage resultsPage = landingPage.clickSearch();
        resultsPage.verifyTrainClassFilter(input.get("class"));
    }

    @Test(dataProvider = "getData", groups = "regression_error")
    public void verifyErrorMessage(HashMap<String, String> input) throws IOException {

        LandingPage landingPage = launchApplication();

        landingPage.searchTrains(input.get("from"), input.get("to"));
        landingPage.selectDate(input.get("month"), input.get("day"));

        SearchResultsPage resultsPage = landingPage.clickSearch();
        resultsPage.verifyErrorMessageIfPresent();
    }
    
    @DataProvider
    public Object[][] getData() throws IOException {

        DataReader reader = new DataReader();

        List<HashMap<String, String>> data =
        		reader.getDataToMap(
        			    System.getProperty("user.dir")
        			    + "/src/com/redbus/test/data/trainData.json"
        			);

        Object[][] obj = new Object[data.size()][1];

        for (int i = 0; i < data.size(); i++) {
            obj[i][0] = data.get(i);
        }

        return obj;
    }
}