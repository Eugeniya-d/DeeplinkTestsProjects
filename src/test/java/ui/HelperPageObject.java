package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;


public class HelperPageObject extends MainPageObject{
    public HelperPageObject(AppiumDriver driver) {
        super(driver);
    }


    public void tapLink() throws InterruptedException {
        OpenDialogAssistantPageObject openDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //Thread.sleep(1000);
        try {
            openDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

       try {
            deeplinkPageObject.link();
        } catch (NoSuchElementException e) {
            deeplinkPageObject.link1();
        }
    }


    public void sendLink(String linkName) {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(linkName);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();
    }
}
