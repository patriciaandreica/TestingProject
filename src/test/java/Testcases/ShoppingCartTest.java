package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

public class ShoppingCartTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }


    // Test to see if you can add product to cart

    @Test
    void AddToCart() {
        WebElement searchProduct = driver.findElement(By.id("search"));
        searchProduct.sendKeys("milk");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='headerPrimary']/div[6]/form/button[2]"));
        searchButton.click();

    }

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }

}
