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
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
//         TODO:
//        check that none of the checkboxes are ticked
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected());
            checkBox.click();
            assertTrue(checkBox.isSelected());
        }
//        tick  "Option 2"
        WebElement option2 = driver.findElement(By.cssSelector(".w2-check[value='Option 2'][type='checkbox']"));
        assertFalse(option2.isSelected());
        option2.click();
        assertTrue(option2.isSelected());
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        WebElement option1 = driver.findElement(By.cssSelector(".w1-check[value='Option 1'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        for (WebElement checkBox : checkBoxes) {
            assertFalse(option1.isSelected());
            assertFalse(option3.isSelected());
            checkBox.click();
            assertTrue(option2.isSelected());
            checkBox.click();
        }

//        tick  "Option 3"
        assertTrue(option3.isSelected());
//        click result
        option3.click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed

        System.out.println("You selected value(s): Option 2, Option 3" + " ");
        for (WebElement checkBox : checkBoxes) {
            assertTrue(option2.isDisplayed());
            assertTrue(option3.isDisplayed());
            checkBox.click();
        }

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed
    }

    @Test
    public void selectOption() throws Exception {

//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByIndex(2);

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
        driver.findElement(By.id("result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
        assertEquals("you selected option 2",
                driver.findElement(By.id("result_select")).getText());

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
        String dateToEnter = "02/05/1959";
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));

        WebElement resultButton = driver.findElement(By.id("result_button_date"));
        WebElement Text_9 = driver.findElement(By.xpath("//*[text()='Date']"));
        Text_9.click();
        resultButton.click();

        WebElement resultText = driver.findElement(By.id("result_date"));
        assertEquals("You entered date: 02/05/1959", resultText.getText());

//        check that correct date is added

    }
}
