package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

public class LogInTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    // Test to see if you can log in
    @Test
    void logIn() throws InterruptedException {
        WebElement logIn = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a"));
        logIn.click();

        WebElement username = driver.findElement(By.xpath("//*[@id='email']"));
        username.sendKeys("myfakeemail@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
        password.sendKeys("Password!");

        WebElement clickSign = driver.findElement(By.xpath("//*[@id='send2']"));
        clickSign.click();
        Thread.sleep(5000);

        WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span"));
        Assert.assertTrue(profile.isDisplayed(), "User is logged in");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
