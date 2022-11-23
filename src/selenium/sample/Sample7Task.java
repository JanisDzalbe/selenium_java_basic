package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import selenium.utility.BootcampUtils;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//         TODO:

//        check that none of the checkboxes are ticked
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
        }
//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        assertFalse(option1.isSelected());
        assertTrue(option2.isSelected());
        assertFalse(option3.isSelected());
//        tick  "Option 3"
        option3.click();
//        click result
        driver.findElement(By.cssSelector("#result_button_checkbox")).click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        WebElement resultText = driver.findElement(By.cssSelector("#result_checkbox"));
        assertEquals("You selected value(s): Option 2, Option 3", resultText.getText());
    }

    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
        WebElement optionOne = driver.findElement(By.id("vfb-7-1"));
        WebElement optionTwo = driver.findElement(By.id("vfb-7-2"));
        WebElement optionThree = driver.findElement(By.id("vfb-7-3"));
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
//        check that none of the radio are selected
        for (WebElement radio : radioButtons) {
            assertFalse(radio.isSelected());
        }
//        select  "Option 3"
        optionThree.click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(optionOne.isSelected());
        assertFalse(optionTwo.isSelected());
        assertTrue(optionThree.isSelected());
//        select  "Option 1"
        optionOne.click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(optionTwo.isSelected());
        assertFalse(optionThree.isSelected());
        assertTrue(optionOne.isSelected());
//        click result
        driver.findElement(By.id("result_button_ratio")).click();
//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_radio"));
        assertEquals("You selected option: Option 1", resultText.getText());
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
        Select dropDown = new Select(driver.findElement(By.id("vfb-12")));
        dropDown.selectByValue("value3");
//        check that selected option is "Option 3"
        assertEquals("Option 3", dropDown.getFirstSelectedOption().getText());
//        select "Option 2" in Select
        dropDown.selectByValue("value2");
//        check that selected option is "Option 2"
        assertEquals("Option 2", dropDown.getFirstSelectedOption().getText());
//        click result
        driver.findElement(By.id("result_button_select")).click();
//        check that 'You selected option: Option 2' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_select"));
        assertEquals("You selected option: Option 2", resultText.getText());
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
        String date = "05/02/1959";
        WebElement calendar = driver.findElement(By.id("vfb-8"));
        calendar.sendKeys(date);
//        check that correct date is added
        assertEquals(date, calendar.getAttribute("value"));
    }
}
