package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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
        WebElement inputNumberField = driver.findElement(By.id("number"));
        WebElement clearResultButton = driver.findElement(By.id("clear_result_button_number"));
        WebElement text = driver.findElement(By.id("result_number"));
        WebElement resultButton = driver.findElement(By.id("result_button_number"));
//        enter a number under "Number"
        inputNumberField.click();
        inputNumberField.clear();
        inputNumberField.sendKeys("8");
//        check that button is not clickable "Clear Result"
        assertFalse(clearResultButton.isEnabled());
//        check that text is not displayed
        assertFalse(text.isDisplayed());
//        click on "Result" button
        resultButton.click();
//        check that text is displayed
        assertTrue(text.isEnabled());
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        String originalNumberInInputNumberField = String.format("You entered number: \"%s\"", inputNumberField.getAttribute("value"));
        assertEquals(text.getText(),originalNumberInInputNumberField);
//        check that the button "Clear Result" is clickable now
        assertTrue(clearResultButton.isDisplayed());
//        click on "Clear Result"
        clearResultButton.click();
//        check that the text is now (""), but it is not displayed
        assertFalse(text.isDisplayed());
        assertEquals(text.getText(), "");
    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());
//        click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();
        assertEquals("This is a home page", driver.findElement(By.id("h1")).getText());
//        check that current url is not base_url
        assertNotEquals(driver.getCurrentUrl(), base_url);
//        verify that current url is homepage
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());
    }
}
