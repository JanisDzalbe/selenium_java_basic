package selenium.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2NextPage {
    @FindBy(how = How.ID, using = "name")
    public WebElement userName;
    @FindBy(how = How.ID, using = "age")
    public WebElement userAge;
    @FindBy(how = How.ID, using = "language")
    public WebElement language;
    @FindBy(how = How.ID, using = "gender")
    public WebElement genre;
    @FindBy(how = How.ID, using = "option")
    public WebElement opinion;
    @FindBy(how = How.ID, using = "comment")
    public WebElement comment;
    @FindBy(how = How.CSS, using = "button[onclick='openFeedback()']")
    public WebElement yesButton;
    @FindBy(how = How.CSS, using = "button[onclick='window.history.back();']")
    public WebElement noButton;

    public void allFieldsEmptyOrNull() {
        assertEquals("", userName.getText());
        assertEquals("", userAge.getText());
        assertEquals("", language.getText());
        assertEquals("null", genre.getText());
        assertEquals("null", opinion.getText());
        assertEquals("", comment.getText());
    }
    public void buttonColors() {
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
    }
    public void fieldsAreFilledCorrectly() {
        assertEquals("John", userName.getText());
        assertEquals("36", userAge.getText());
        assertEquals("Spanish", language.getText());
        assertEquals("male", genre.getText());
        assertEquals("Why me?", opinion.getText());
        assertEquals("Free text to send", comment.getText());
    }
    public void clickYesButton() {
        yesButton.click();
    }
    public void clickNoButton() {
        noButton.click();
    }
}
