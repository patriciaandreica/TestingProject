package Testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class ProductDetailTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // Are product details there
    @Test
    public void productDetail() throws InterruptedException {
        WebElement searchProduct = driver.findElement(By.xpath("//*[@id='search']"));
        searchProduct.sendKeys("bag");
        searchProduct.sendKeys(Keys.RETURN);

        Thread.sleep(5000);

        WebElement product = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"));
        product.click();

        // Verify that the product has a price and description
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product-price-14']/span")));
        String price = priceElement.getText();
        assertNotNull(price, "Product price is missing");

        WebElement descriptionElement = driver.findElement(By.xpath("//*[@id='description']/div/div/p"));
        String description = descriptionElement.getText();
        assertNotNull(description, "Product description is missing");
    }

    // Verify that you can filter by lowest to highest price
    @Test(dependsOnMethods = { "productDetail" })
    public void filterByLowestToHighest() throws InterruptedException {
        WebElement searchProduct = driver.findElement(By.xpath("//*[@id='search']"));
        searchProduct.sendKeys("tees");
        searchProduct.sendKeys(Keys.RETURN);

        // Click to sort by price
        WebElement sortByDropdown = driver.findElement(By.xpath("//*[@id='sorter']"));
        sortByDropdown.click();
        WebElement lowestToHighestOption = driver.findElement(By.xpath("//*[@id='sorter']/option[2]"));
        lowestToHighestOption.click();

        WebElement lowestOption = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[1]/div[3]/a"));
        lowestOption.click();

        // Verify that the search results are sorted by lowest to highest price
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("span.price"))));
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : priceElements) {
            try {
                String priceString = priceElement.getText().replace("$", "");
                prices.add(Double.parseDouble(priceString));
            } catch (StaleElementReferenceException e) {
                WebDriverWait waitAgain = new WebDriverWait(driver, Duration.ofSeconds(10));
                priceElement = waitAgain.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.price")));
                String priceString = priceElement.getText().replace("$", "");
                prices.add(Double.parseDouble(priceString));
            }
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        Thread.sleep(5000);
        assertEquals(prices, sortedPrices, "Search results are not sorted by lowest to highest price");
    }

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}
