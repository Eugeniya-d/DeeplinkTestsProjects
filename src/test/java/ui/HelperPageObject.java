package ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;


public class HelperPageObject extends MainPageObject {


    public HelperPageObject(AppiumDriver driver) {
        super(driver);
    }


    public void tapLink(String link) {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(link);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

       try {
            deeplinkPageObject.link();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }

        try {
            deeplinkPageObject.link1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void assertTitle(String titleText) {
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        Assert.assertEquals(
                "Кнопка не привела в раздел " + titleText,
                DeeplinkPageObject.waitForTitlePresent(titleText).getAttribute("text"),
                titleText
        );
    }
}
