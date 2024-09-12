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
        System.out.println(driver.findElement(By.xpath("//*[@id='heading_2']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Heading 2 text']")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println(driver.findElement(By.xpath("//*[@id='test1']/p[@class='test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Test Text 1']")).getText());
//        1-2 ways to find text: "Test Text 2"
        System.out.println(driver.findElement(By.xpath("//div[@id='test1']//p[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='test1']//p[@class='twoTest']")).getText());
        //        1-2 ways to find text: "Test Text 3"
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[position()=1]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Test Text 3']")).getText());
//        1-2 ways to find text: "Test Text 4"
        System.out.println(driver.findElement(By.xpath("//*[@id='test3']/p[position()=2]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Test Text 4']")).getText());
//        1-2 ways to find text: "Test Text 5"
        System.out.println(driver.findElement(By.xpath("//*[@id='test2']/p[@class='Test']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[text()='Test Text 5']")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println(driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");
        System.out.println(driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("name") + "'");
    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
        System.out.println(driver.findElement(By.cssSelector("#heading_2")).getText());
        System.out.println(driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText());
//        1-2 ways to find text: "Test Text 1"
        System.out.println(driver.findElement(By.cssSelector("#test1 > .test")).getText());
        System.out.println(driver.findElement(By.cssSelector("#test1 > p.test")).getText()+"'");;
//        1-2 ways to find text: "Test Text 2"
        System.out.println(driver.findElement(By.cssSelector("p.twotest")).getText() + "'");
        System.out.println(driver.findElement(By.cssSelector("#heading_2 + div .twoTest")).getText());
//        1-2 ways to find text: "Test Text 3"
        System.out.println(driver.findElement(By.cssSelector("#test3 .test")).getText() + "'");
        System.out.println(driver.findElement(By.cssSelector("#test3 p:first-child")).getText());
//        1-2 ways to find text: "This is also a button"
        System.out.println(driver.findElement(By.cssSelector("[value='This is also a button']")).getAttribute("name") + "'");
    }
}
