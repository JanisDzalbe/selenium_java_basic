package selenium.sample;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static selenium.sample.Sample1.libWithDriversLocation;

public class Sample1Task {

    @Test
    public void goToHomepage() throws Exception {
//        TODO:
//         define driver
        //WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
//         go to https://kristinek.github.io/site/index2.html
        driver.get("https://kristinek.github.io/site/index2.html");
//         get title of page
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
//         get URL of current page
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL is: " + currentURL);

        Thread.sleep(10000);
//         close browser
        driver.quit();

    }
}