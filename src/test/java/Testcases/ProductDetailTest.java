package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.WebDriverSetup;

public class AskQuestionTest {
    WebDriver driver;
    WebDriverSetup webDriverSetup;

    @BeforeClass
    public void setUp() throws InterruptedException {
        webDriverSetup = new WebDriverSetup();
        webDriverSetup.setUp();
        driver = webDriverSetup.getDriver();
    }

    @Test
    public void askQuestion() {

    }


    @AfterClass
    public void tearDown() {
        webDriverSetup.quitDriver();
    }
}
