package tests;
import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.ComfirmPermissionsPageObject;
import ui.MainScreenPageObject;
import ui.SettingsPageObject;
import ui.SignUpPageObject;


public class LoginIFTSbolTest extends CoreTestCase {

    @Test
    public void testLoginIFTSbol() throws InterruptedException {
        ComfirmPermissionsPageObject ComfirmPermissionsPageObject = new ComfirmPermissionsPageObject(driver);
        SettingsPageObject SettingsPageObject = new SettingsPageObject(driver);
        SignUpPageObject SignUpPageObject = new SignUpPageObject(driver);
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);

        ComfirmPermissionsPageObject.confirmAgreement();
        ComfirmPermissionsPageObject.comfirmPermission();
        ComfirmPermissionsPageObject.allowPermission();
        ComfirmPermissionsPageObject.allowPermission();
        Thread.sleep(1000);
        ComfirmPermissionsPageObject.allowPermission();

        Thread.sleep(1000);
        SettingsPageObject.menuSettings(1010, 159);
        SettingsPageObject.chooseTestingSettings();
        SettingsPageObject.chooseTogglesButton();
        SettingsPageObject.searchToggles();
        SettingsPageObject.inputToggleName("ATHENADEV_FAKE_VPS_ENABLED");
        SettingsPageObject.activateToggle();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.backToTogglesMenu();
        SettingsPageObject.backToHomeScreen();
        Thread.sleep(1000);
        SettingsPageObject.menuSettings(1010, 159);
        SettingsPageObject.selectServer();
        SettingsPageObject.selectIFT();

        SignUpPageObject.signUp();
        SignUpPageObject.signUpByLogin();
        SignUpPageObject.clickInputLoginString();
        SignUpPageObject.inputLogin("p2pvoice4");
        SignUpPageObject.confirmLogin();
        SignUpPageObject.inputPassword();
        SignUpPageObject.inputPassword();
        SignUpPageObject.skipWarning();

        String buttontext = "Главный";

        Assert.assertEquals(
                "Вход в СБОЛ ИФТ не был осуществлен",
                MainScreenPageObject.waitForHomeButton().getAttribute("text"),
                buttontext
        );
    }
}

