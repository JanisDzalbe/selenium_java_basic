package selenium.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2ThankYouPage {

    @FindBy(how = How.CSS, using = ".w3-green")
    private WebElement thankYouMessage;

    public void messageText() {
        assertEquals("Thank you, Anna, for your feedback!", thankYouMessage.getText());
    }
    public void colorOfMessage() {
        assertEquals("rgba(76, 175, 80, 1)", thankYouMessage.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", thankYouMessage.getCssValue("color"));
    }
    public void messageTextWithoutData() {
        assertEquals("Thank you for your feedback!", thankYouMessage.getText());
    }
}
