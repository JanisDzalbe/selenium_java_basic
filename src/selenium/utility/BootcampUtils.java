package selenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BootcampUtils {
    public static WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Constants.libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // initialize driver and return
        return new ChromeDriver(options);

    }
}
