package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;


public class HelperPageObject extends MainPageObject {


    public HelperPageObject(AppiumDriver driver) {
        super(driver);
    }


    public void tapLink() {
        OpenDialogAssistantPageObject openDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            openDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

      /* try {
            deeplinkPageObject.link();
        } catch (NoSuchElementException e) {
            deeplinkPageObject.link1();
        }*/
        //deeplinkPageObject.waitForPayLink();
       // deeplinkPageObject.tapToPayLink();
        deeplinkPageObject.link1();
    }


    public void sendLink(String linkName) {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(linkName);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();
    }
}
