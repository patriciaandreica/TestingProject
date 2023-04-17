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

public class CompareListTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    @Test
    public void compareList() throws InterruptedException {
        WebElement searchProduct = driver.findElement(By.xpath("//*[@id='search']"));
        searchProduct.sendKeys("bag");
        searchProduct.sendKeys(Keys.RETURN);

        WebElement firstProduct = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"));
        firstProduct.click();
        WebElement addCompare1 = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[5]/div/a[2]"));
        addCompare1.click();

        Thread.sleep(5000);

        WebElement secondProduct = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[5]/div[2]/div/ol/li[1]/div/div/strong/a"));
        secondProduct.click();
        WebElement addCompare2 = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[5]/div/a[2]"));
        addCompare2.click();

        Thread.sleep(5000);

        WebElement viewList = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/ul/li/a"));
        viewList.click();

        Thread.sleep(5000);

        List<WebElement> compareList = driver.findElements(By.cssSelector("td.cell.product.info"));
        assertTrue(compareList.size() == 2, "Number of items in compare list is less than 2");
    }

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}