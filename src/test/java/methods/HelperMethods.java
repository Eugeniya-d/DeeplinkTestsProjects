package methods;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import ui.*;

import java.util.concurrent.TimeUnit;


public class HelperMethods extends MainPageObject {


    public HelperMethods(AppiumDriver driver) {
        super(driver);
    }


    public void tapLink(String link) {
        OpenDialogAssistantPageObject openDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);

        openDialogAssistantPageObject.clickInputLine();
        openDialogAssistantPageObject.inputText(link);
        openDialogAssistantPageObject.sendMessage();
        openDialogAssistantPageObject.sendMessage();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        try {
            openDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

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

    public void openSbolIFTandAssistantDialog(String login) {
        ComfirmPermissionsPageObject ComfirmPermissionsPageObject = new ComfirmPermissionsPageObject(driver);
        SettingsPageObject SettingsPageObject = new SettingsPageObject(driver);
        SignUpPageObject SignUpPageObject = new SignUpPageObject(driver);
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        ComfirmPermissionsPageObject.confirmAgreement();
        ComfirmPermissionsPageObject.comfirmPermission();
        ComfirmPermissionsPageObject.allowPermission();
        ComfirmPermissionsPageObject.allowPermission();
        ComfirmPermissionsPageObject.waitForAllowPermission();
        ComfirmPermissionsPageObject.allowPermission();

        SettingsPageObject.waitForMenuButton();
        SettingsPageObject.clickMenuButton();
        SettingsPageObject.selectServer();
        SettingsPageObject.selectIFT();
        SettingsPageObject.waitForMenuButton();
        SettingsPageObject.clickMenuButton();
        SettingsPageObject.chooseTestingSettings();
        SettingsPageObject.chooseTogglesButton();
        SettingsPageObject.searchToggles();
        SettingsPageObject.inputToggleName("FAKE");
        SettingsPageObject.activateToggle();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.backToTogglesMenu();
        SettingsPageObject.backToHomeScreen();

        SignUpPageObject.signUpByLogin();
        SignUpPageObject.clickInputLoginString();
        SignUpPageObject.waitForInputLogin();
        SignUpPageObject.inputLogin(login);
        SignUpPageObject.confirmLogin();
        SignUpPageObject.inputPassword();
        SignUpPageObject.waitForInputPassword();
        SignUpPageObject.inputPassword();
        SignUpPageObject.skipWarning();

        MainScreenPageObject.enterToAssistant();
        OpenDialogAssistantPageObject.selectKeyboard();
    }

    public void closePopUp() {
        DeeplinkPageObject deeplinkPageObject = new DeeplinkPageObject(driver);
        try {
            deeplinkPageObject.popUpClose();
        } catch (Exception e) {
            this.assertTitle("Подключение уведомлений");
            System.out.println(e.getMessage());
        }
    }
}
