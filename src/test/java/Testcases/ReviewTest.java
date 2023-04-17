package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ReviewTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // Does product have reviews
    @Test
    public void productHasReviews() throws InterruptedException {
        WebElement searchProduct = driver.findElement(By.xpath("//*[@id='search']"));
        searchProduct.sendKeys("pants");
        searchProduct.sendKeys(Keys.RETURN);

        WebElement product = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"));
        product.click();

        // Click on the "Reviews"
        WebElement reviewsTab = driver.findElement(By.xpath("//*[@id='maincontent']/div[2]/div/div[1]/div[2]"));
        reviewsTab.click();

        Thread.sleep(3000);
        // Check if there are any reviews
        List<WebElement> reviewElements = driver.findElements(By.cssSelector("li.item.review-item"));
        assertTrue(reviewElements.size() > 0, "Product has no reviews");
    }

    @Test(dependsOnMethods = { "productHasReviews" })
    public void addReview(){
        WebElement starRating = driver.findElement(By.xpath("//*[@id='Rating_4_label']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(starRating).click().build().perform();

        WebElement nickname = driver.findElement(By.xpath("//*[@id='nickname_field']"));
        nickname.sendKeys("Walter");

        WebElement summary = driver.findElement(By.xpath("//*[@id='summary_field']"));
        summary.sendKeys("Amazing");

        WebElement description = driver.findElement(By.xpath("//*[@id='review_field']"));
        description.sendKeys("Great quality");

        WebElement submitButton = driver.findElement(By.xpath("//*[@id='review-form']/div/div/button"));
        submitButton.click();

        WebElement confirmation = driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/div[2]/div"));
        assertTrue(confirmation.isDisplayed());
    }

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}
