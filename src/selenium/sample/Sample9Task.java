package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.utility.BootcampUtils;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Sample9Task {
    WebDriver driver;

    @BeforeEach
    public void openPage() {
        // Initialize driver
        driver = BootcampUtils.initializeChromeDriver();

        // load web page
        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @AfterEach
    public void closeBrowser() {

        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {

//         TODO:
        WebElement greenButtonStart = driver.findElement(By.id("start_green"));
//         * 1) click on start loading green button
        assertTrue(greenButtonStart.isDisplayed());
        greenButtonStart.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButtonStart.isDisplayed());
        WebElement greenButtonLoading = driver.findElement(By.id("loading_green"));
        assertTrue(greenButtonLoading.isDisplayed());
        Thread.sleep(5000);
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenButtonFinish = driver.findElement(By.id("finish_green"));
        assertFalse(greenButtonStart.isDisplayed());
        assertFalse(greenButtonLoading.isDisplayed());
        assertTrue(greenButtonFinish.isDisplayed());
        assertEquals("Green Loaded",greenButtonFinish.getText());
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         * 1) click on start loading green button
        WebElement greenButtonStart = driver.findElement(By.id("start_green"));
        assertTrue(greenButtonStart.isDisplayed());
        greenButtonStart.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement greenButtonLoading = driver.findElement(By.id("loading_green"));
        assertTrue(greenButtonLoading.isDisplayed());
        assertEquals("Loading green...",greenButtonLoading.getText());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenButtonFinish = driver.findElement(By.id("finish_green"));
        assertFalse(greenButtonStart.isDisplayed());
        assertFalse(greenButtonLoading.isDisplayed());
        assertTrue(greenButtonFinish.isDisplayed());
        assertEquals("Green Loaded",greenButtonFinish.getText());
    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class);
//         * 1) click on start loading green button
        WebElement greenButtonStart = driver.findElement(By.id("start_green"));
        assertTrue(greenButtonStart.isDisplayed());
        greenButtonStart.click();
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        WebElement greenButtonLoading = driver.findElement(By.id("loading_green"));
        wait.until(ExpectedConditions.visibilityOf(greenButtonLoading));
        assertEquals("Loading green...", greenButtonLoading.getText());
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        wait.until(ExpectedConditions.invisibilityOf(greenButtonLoading));
        WebElement greenButtonFinish = driver.findElement(By.id("finish_green"));
        assertFalse(greenButtonStart.isDisplayed());
        assertFalse(greenButtonLoading.isDisplayed());
        assertTrue(greenButtonFinish.isDisplayed());
        assertEquals("Green Loaded",greenButtonFinish.getText());
    }

    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         */
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10))
                .ignoring(StaleElementReferenceException.class);
        //wait until button to load green and blue appears
        WebElement greenAndBlueButtonStart = driver.findElement(By.id("start_green_and_blue"));
        wait.until(ExpectedConditions.visibilityOf(greenAndBlueButtonStart));
        assertTrue(greenAndBlueButtonStart.isDisplayed());
        //click on start loading green and blue button
        greenAndBlueButtonStart.click();
        //check that button does not appear, but loading text is seen instead for green
        assertFalse(greenAndBlueButtonStart.isDisplayed());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_green_without_blue")));
        WebElement greenLoadingWithoutBlue = driver.findElement(By.id("loading_green_without_blue"));
        assertTrue(greenLoadingWithoutBlue.isDisplayed());
        //check that button does not appear, but loading text is seen instead for green and blue
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_green_with_blue")));
        WebElement greenWithBlueLoading = driver.findElement(By.id("loading_green_with_blue"));
        assertFalse(greenAndBlueButtonStart.isDisplayed());
        assertTrue(greenLoadingWithoutBlue.isDisplayed());
        assertTrue(greenWithBlueLoading.isDisplayed());
        //check that button and loading green does not appear,
        // but loading text is seen instead for blue and success for green is seen
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loading_blue_without_green")));
        WebElement blueWithGreenLoading = driver.findElement(By.id("loading_blue_without_green"));
        assertFalse(greenAndBlueButtonStart.isDisplayed());
        assertFalse(greenLoadingWithoutBlue.isDisplayed());
        assertTrue(greenWithBlueLoading.isDisplayed());
        assertTrue(blueWithGreenLoading.isDisplayed());
        //check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish_green_and_blue")));
        WebElement greenAndBlueFinish = driver.findElement(By.id("finish_green_and_blue"));
        assertFalse(greenAndBlueButtonStart.isDisplayed());
        assertFalse(greenWithBlueLoading.isDisplayed());
        assertFalse(blueWithGreenLoading.isDisplayed());
        assertTrue(greenAndBlueFinish.isDisplayed());



    }

}