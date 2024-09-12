package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.utility.BootcampUtils;

import java.io.File;

public class Sample6Task {
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
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text":
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t text of element with id 'heading_2' is '" +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\t text of element with id 'test text 1' is '" +
                driver.findElement(By.xpath("//div[@id='test1']/p")).getText() + "'");
        System.out.println("\t text of element with id 'test text 1' is '" +
                driver.findElement(By.cssSelector("div#test1 > p")).getText() + "'");

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\t text of element with id 'test text 2' is '" +
                driver.findElement(By.xpath("//div[@id='test1']/p")).getText() + "'");
        System.out.println("\t text of element with id 'test text 2' is '" +
                driver.findElement(By.cssSelector("div#test1 > p")).getText() + "'");

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\t text of element with id 'test text 3' is '" +
                driver.findElement(By.xpath("//div[@id='test3']/p")).getText() + "'");
        System.out.println("\t text of element with id 'test text 3' is '" +
                driver.findElement(By.cssSelector("div#test3 > p")).getText() + "'");
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"
        System.out.println("\t text of element with id 'this is also a button' is '" +
                driver.findElement(By.xpath("//*[@id='buttonId']")).getAttribute("value" + "'"));
        //System.out.println("\t text of element with id 'this is also a button' is '" +
                //driver.findElement(By.cssSelector("#buttonId")).getAttribute("value" + "'"));
        System.out.println(driver.findElement(
                By.xpath("//input[@name='randomButton2']")).getAttribute("value"));
        System.out.println(driver.findElement(
                        By.xpath("//input[@type='button' and @id='buttonId' and @name='randomButton2']"))
                .getAttribute("value"));

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"


//        1-2 ways to find text: "Test Text 1"

//        1-2 ways to find text: "Test Text 2"

//        1-2 ways to find text: "Test Text 3"

//        1-2 ways to find text: "This is also a button"
    }
}
