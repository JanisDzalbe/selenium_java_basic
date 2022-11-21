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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @BeforeEach
    public void startingTests() throws Exception {
        // Initialize driver
        driver = BootcampUtils.initializeChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @AfterEach
    public void endingTests() throws Exception {
        driver.quit();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//
//         check how many element with class "test" there are on page (5)
        assertEquals(5, driver.findElements(By.className("test")).size());
        //         check that value of second button is "This is also a button"
        String valueOfSecondButton = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertEquals("This is also a button", valueOfSecondButton);
    }

    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String valueOfSecondButton = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertTrue(valueOfSecondButton.equalsIgnoreCase("this is Also a Button"));
        //fail with custom error message:
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String valueOfSecondButton = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertFalse(valueOfSecondButton.equals("This is a button"));
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        List<WebElement> allElementsTestClass = driver.findElements(By.className("test"));
        for (WebElement elementOfTestClass : allElementsTestClass) {
            String elementText = elementOfTestClass.getText();
            assertFalse(elementText.contains("190"));
        }
    }
}
