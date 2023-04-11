package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverSetup {
    public WebDriver driver;

    public void setUp() {
        // Set up the ChromeDriver instance
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\java\\utils\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // create the first instance of ChromeDriver
        driver = new ChromeDriver(options);
        driver.get("https://www.target.com/");
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
