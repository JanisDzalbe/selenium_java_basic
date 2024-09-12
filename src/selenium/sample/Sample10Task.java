package selenium.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.ColorSamplePage;
import selenium.utility.BootcampUtils;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Sample10Task {
    static WebDriver driver;
    static ColorSamplePage colorPage;

    @BeforeEach
    public void openPage() {
        // Initialize driver
        driver = BootcampUtils.initializeChromeDriver();

        // Set timeout and open page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://kristinek.github.io/site/examples/loading_color");
        colorPage = PageFactory.initElements(driver, ColorSamplePage.class);
    }

    @AfterEach
    public void closeBrowser() {

        driver.close();
    }


    @Test
    public void greenLoading() {
        //         * 1) click on start loading green button
        colorPage.clickStartLoadingGreen();
//         * 2) check that button does not appear,
        colorPage.visibilityOfGreenButton();
//         * but loading text is seen instead   "Loading green..."
        colorPage.visibilityOfLoadingGreen();
//         * 3) check that both button
        colorPage.visibilityOfGreenButton();
//         * and loading text is not seen,
        colorPage.invisibilityOfLoadingGreen();
//         * success is seen instead "Green Loaded"
        colorPage.visibilityOfGreenLoadingFinish();
    }


}