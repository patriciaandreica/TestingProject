package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // Verify product added to cart
    @Test
    void addToCart() throws InterruptedException {
        WebElement searchProduct = driver.findElement(By.xpath("//*[@id='search']"));
        searchProduct.sendKeys("shirt");
        searchProduct.sendKeys(Keys.RETURN);

        WebElement product = driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/strong/a"));
        product.click();

        Thread.sleep(5000);

        WebElement productSize = driver.findElement(By.xpath("//*[@id='option-label-size-143-item-168']"));
        productSize.click();
        WebElement productColor = driver.findElement(By.xpath("//*[@id='option-label-color-93-item-50']"));
        productColor.click();

        Thread.sleep(3000);

        WebElement addButton = driver.findElement(By.xpath("//*[@id='product-addtocart-button']"));
        addButton.click();

        Thread.sleep(7000);

        WebElement cartCount = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a/span[2]/span[1]"));
        assertEquals("1", cartCount.getText(), "The product was not added to the cart");

    }

    // Verify you can remove items from cart
    @Test
    void removeItem() throws InterruptedException {
        WebElement cartButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a"));
        cartButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id='mini-cart']/li/div/div/div[3]/div[2]/a"));
        deleteButton.click();

        Thread.sleep(3000);

        WebElement okButton = driver.findElement(By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[2]"));
        okButton.click();

        Thread.sleep(3000);

        WebElement cartCount = driver.findElement(By.xpath("//*[@id='minicart-content-wrapper']/div[2]/strong"));
        assertEquals("You have no items in your shopping cart.", cartCount.getText(), "The product was not added to the cart");

    }

    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }

}
