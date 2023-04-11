package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverSetup;

public class ReviewTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // click on a product

    // can submit a review

    // can not submit review if a field is missing

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}
