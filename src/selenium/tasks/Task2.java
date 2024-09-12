package selenium.tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.AgeSamplePage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2 {
    WebDriver driver;
    static Task2Page task2Page;
    static Task2NextPage task2NextPage;
    static Task2ThankYouPage task2ThankYouPage;
    @BeforeEach
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        task2Page = PageFactory.initElements(driver, Task2Page.class);
        task2NextPage = PageFactory.initElements(driver, Task2NextPage.class);
        task2ThankYouPage = PageFactory.initElements(driver, Task2ThankYouPage.class);
    }

    @AfterEach
    public void closeBrowser() {

        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no ticks are clicked
        task2Page.allFieldsEmpty();
        task2Page.noTicksAreClicked();
//         "Don't know" is selected in "Genre"
        task2Page.setDontKnowOption();
//         "Choose your option" in "How do you like us?"
        task2Page.chooseHowDoYouLikeUsOption();
//         check that the button send is blue with white letters
        task2Page.sendButtonColor();
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        task2Page.clickSend();
//         check fields are empty or "null"
        task2NextPage.allFieldsEmptyOrNull();
//         check button colors
//         (green with white letter and red with white letters)
        task2NextPage.buttonColors();
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO
//         fill the whole form, click "Send"
        task2Page.fillTheForm();
        task2Page.clickSend();
//         check fields are filled correctly
        task2NextPage.fieldsAreFilledCorrectly();
//         check button colors
//         (green with white letter and red with white letters)
        task2NextPage.buttonColors();
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        task2Page.enterName("Anna");
//         click "Send"
        task2Page.clickSend();
//         click "Yes"
        task2NextPage.clickYesButton();
//         check message text: "Thank you, NAME, for your feedback!"
        task2ThankYouPage.messageText();
//         color of text is white with green on the background
        task2ThankYouPage.colorOfMessage();
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        task2Page.clickSend();
//         click "Yes"
        task2NextPage.clickYesButton();
//         check message text: "Thank you for your feedback!"
        task2ThankYouPage.messageTextWithoutData();
//         color of text is white with green on the background
        task2ThankYouPage.colorOfMessage();
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        task2Page.fillTheForm();
//         click "Send"
        task2Page.clickSend();
//         click "No"
        task2NextPage.clickNoButton();
//         check fields are filled correctly
        task2Page.fieldsAreFilledCorrectly();
    }

}
