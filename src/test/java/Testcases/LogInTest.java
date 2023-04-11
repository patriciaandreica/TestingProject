package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverSetup;

public class LogInTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // Test ability to log in with real credentials
    // Test if invalid login



    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }

}
