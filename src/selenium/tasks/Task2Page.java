package selenium.tasks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Page {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    public List<WebElement> checks;
    @FindBy(how = How.CSS, using = ".w3-radio:nth-of-type(1)")
    public WebElement maleOption;
    @FindBy(how = How.CSS, using = ".w3-radio:nth-of-type(2)")
    private WebElement femaleOption;
    @FindBy(how = How.CSS, using = ".w3-radio:nth-of-type(3)")
    public WebElement dontKnowOption;
    @FindBy(how = How.ID, using = "like_us")
    private WebElement dropdown;
    @FindBy(how = How.NAME, using = "comment")
    private WebElement comment;
    @FindBy(how = How.CSS, using = ".w3-btn-block")
    private WebElement sendButton;


    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }


    public void clickSend() {
        sendButton.click();
    }

    public void allFieldsEmpty() {
        assertEquals("", nameInput.getText());
        assertEquals("", ageInput.getText());
        assertEquals("", comment.getText());
    }

    public void noTicksAreClicked() {
        for (WebElement items : checks) {
            assertFalse(items.isSelected());
        }
    }

    public void setDontKnowOption() {
        assertTrue(dontKnowOption.isSelected());
    }

    public void chooseHowDoYouLikeUsOption() {
        Select dropDown = new Select(dropdown);
        dropDown.selectByVisibleText("Why me?");
    }

    public void sendButtonColor() {

        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
    }

    public void fillTheForm() {
        nameInput.sendKeys("John");
        ageInput.sendKeys("36");
        checks.get(2).click();
        maleOption.click();
        Select dropDown = new Select(dropdown);
        dropDown.selectByIndex(4);
        comment.sendKeys("Free text to send");
    }
    public String getHowDoYouLikeUsValue(){
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
    public void fieldsAreFilledCorrectly() {
        assertEquals("John", nameInput.getAttribute("value"));
        assertEquals("36", ageInput.getAttribute("value"));
        assertTrue(checks.get(2).isSelected());
        assertTrue(maleOption.isSelected());
        assertEquals("Why me?", getHowDoYouLikeUsValue());
        assertEquals("Free text to send", comment.getAttribute("value"));;
    }

}
