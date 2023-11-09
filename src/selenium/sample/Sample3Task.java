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
//         TODO:
//         check how many element with class "test" there are on page (5)
        //assertEquals(driver.findElement(By.className("test")).size(), 5);
        assertEquals(5, driver.findElements(By.className("test")).size());
        // check that value of second button is "This is also a button"
        assertEquals("This is also a button", driver.findElement(By.name("randomButton2")).getAttribute("value"));
//
    }
    @Test
    public void assertTrueTask() throws Exception {
//         TODO:
//         check that it is True that value of second button is
//         "this is Also a Button" if you ignore Caps Locks
//         fail with custom error message:
        String buttonTextValue = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertTrue(buttonTextValue.equalsIgnoreCase("This is Also a Button"));
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
        String buttonTextValue = driver.findElement(By.id("buttonId")).getAttribute("value");
        assertFalse(buttonTextValue.equals("This is a button"), "Fail, message is not visible");
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test"
//        contain number 190
        String number = "190";
        List<WebElement> allElementsWithClass = driver.findElements(By.className("test"));

        for (WebElement elementWithClass: allElementsWithClass) {
            System.out.println(elementWithClass.getText());
            assertFalse(elementWithClass.getText().equals(number));
            assertFalse(elementWithClass.getText().contains(number), "Message");

            assertNotEquals(elementWithClass.getText(), "They are equal");


            //List<WebElement> elementTextOnPage = driver.findElements(By.className(classTest));
           // try {
              //  for (WebElement element: elementTextOnPage){
              //      assertFalse(element.getText().contains("190"),"Message");
                //}
           // } catch (AssertionError e) {
            //    e.printStackTrace();
           // }



        }


    }
}
