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

import static org.junit.jupiter.api.Assertions.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @BeforeEach
    public void startingTests() throws Exception {
        // Initialize driver
        driver = BootcampUtils.initializeChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @AfterEach
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//
//
//        enter a number under "Number"
        int number = 7;

        WebElement enternumber = driver.findElement(By.id("number"));
        enternumber.click();
        enternumber.clear();
        enternumber.sendKeys("44");

//        check that button is not clickable "Clear Result"
        WebElement clearButton = driver.findElement(By.id("clear result button number"));
        assertFalse(clearButton.isEnabled());
//        check that text is not displayed
        WebElement text = driver.findElement(By.id("result number"));
        text.getText();
        assertFalse(text.isDisplayed());

//        click on "Result" button
        WebElement resultButton = driver.findElement(By.id("result button"));
        resultButton.click();
//        check that text is displayed
        assertTrue(text.isDisplayed());
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals(number, enternumber.getAttribute("value"));
//        check that the button "Clear Result" is clickable now
        assertTrue(clearButton.isDisplayed());
//        click on "Clear Result"
        clearButton.click();
//        check that the text is now (""), but it is not displayed
        assertEquals(text.getText(), "", "Text should be");
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        WebElement link = driver.findElement(By.id("homepage_link"));
        assertEquals(driver.getCurrentUrl(), base_url, "Current url should be the same as the base url");
//        click on "This is a link to Homepage"
        link.click();
//        check that current url is not base_url

        String baseURL = "https://kristinek.github.io/site/";

        assertFalse(link.equals(baseURL), "Current URL is the same as the base URL");
        }

//        verify that current url is homepage
    }

