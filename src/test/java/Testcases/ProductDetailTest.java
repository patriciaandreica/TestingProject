package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverSetup;

public class ProductDetailTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // search for a product

    // product name, price, description, images are there


    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}
