package selenium.sample;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.utility.BootcampUtils;
import selenium.utility.Constants;

import java.io.File;

public class Sample1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @Test
    public void goToHomepage() throws Exception {

        // Set system property - we will have a method to do this from now on
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // initialize driver
        WebDriver driver = new ChromeDriver(options);

        /* From now on, we will use this initialization utility method to not have repeated code:
        driver = BootcampUtils.initializeChromeDriver();
         */

        //open test homepage
        driver.get("https://kristinek.github.io/site/");
        System.out.println(driver.findElement(By.id("h1")).getText());
        //get title of page
        System.out.println(driver.getTitle());
        //get URL of current page
        System.out.println(driver.getCurrentUrl());
        //Sleep for 10 seconds
        Thread.sleep(10000);

        //Close browser
        driver.quit();
    }
}
