package com.redbus.test.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.redbus.test.LandingPage;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir")
                + "\\src\\com\\redbus\\test\\resources\\GlobalData.properties"
        );
        prop.load(file);

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        else {
            driver = new ChromeDriver();
            System.out.println("Defaulting to Chrome browser");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public LandingPage launchApplication() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        if (driver == null) {
            System.out.println("Driver is null. Screenshot not captured.");
            return null;
        }

        TakesScreenshot ss = (TakesScreenshot) driver;
        File source = ss.getScreenshotAs(OutputType.FILE);

        File dir = new File(System.getProperty("user.dir") + "//reports");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, testCaseName + ".png");
        FileUtils.copyFile(source, file);

        return file.getAbsolutePath();
    }

    @AfterMethod(alwaysRun = true)
    public void afterExecu() {

        if (driver != null) {
            driver.quit();
        }
    }
}
