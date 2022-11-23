package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.utility.BootcampUtils;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sample8Task {
    WebDriver driver;

    // method which is being run before each test
    @BeforeEach
    public void startingTests() throws Exception {
        // Initialize driver
        driver = BootcampUtils.initializeChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/po");
    }

    // method which is being run after each test
    @AfterEach
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void styleChecks() throws Exception {
//         TODO:
//        check the background of top 2 sections
//        rgba(255, 221, 221, 1);
//        check h1 element font-size 64px
        WebElement leftTop = driver.findElement(By.className("w3-pale-red"));
        WebElement rightTop = driver.findElement(By.className("w3-pale-yellow"));
        WebElement h1 = driver.findElement(By.cssSelector("h1"));
        assertEquals("rgba(255, 221, 221, 1)",leftTop.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 204, 1)",rightTop.getCssValue("background-color"));
        assertEquals("64px",h1.getCssValue("font-size"));
    }
}
