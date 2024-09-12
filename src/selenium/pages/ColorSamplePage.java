package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class ColorSamplePage extends GenericSamplePage {
    //         TODO:
//         Define elements in page
//         see https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
    @FindBy(how = How.ID, using = "start_green")
    private WebElement greenButton;
    @FindBy(how = How.ID, using = "loading_green")
    private WebElement loadingGreen;
    @FindBy(how = How.ID, using = "finish_green")
    private WebElement finishGreen;


    public void clickStartLoadingGreen() {
//         TODO:
//         implement clicking on "Start loading green" button
        greenButton.click();
    }

    //         TODO
//         Implement methods for:
//         * 1) check that "Start loading green" button is not visible
    public void visibilityOfGreenButton() {
        assertFalse(greenButton.isDisplayed());
    }

    //         * 2) check that text "Loading green..." is visible
    public void visibilityOfLoadingGreen() {
        assertTrue(loadingGreen.isDisplayed());
    }

    //         * 3) check that text "Loading green..." is not visible
    public void invisibilityOfLoadingGreen() {

        assertTrue(finishGreen.isDisplayed());
        assertFalse(loadingGreen.isDisplayed());
    }

    //         * 4) check that text "Green Loaded" is visible
    public void visibilityOfGreenLoadingFinish() {
        assertTrue(finishGreen.isDisplayed());
    }
}
