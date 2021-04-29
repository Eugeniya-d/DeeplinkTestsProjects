package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;

public class HelperPageObject extends MainPageObject{
    public HelperPageObject(AppiumDriver driver) {
        super(driver);
    }


    public void tapLink() throws InterruptedException {
        OpenDialogAssistantPageObject openDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);
        Thread.sleep(1000);
        try {
            openDialogAssistantPageObject.denyAssistantNotification();
            deeplinkPageObject.link1();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        deeplinkPageObject.link();
       /* try {
            deeplinkPageObject.link();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            deeplinkPageObject.link1();
        }*/
    }

    public void sendLink(String linkName) {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(linkName);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();
    }
}
