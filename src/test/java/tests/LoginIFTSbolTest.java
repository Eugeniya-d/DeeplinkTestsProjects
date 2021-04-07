package tests;
import lib.CoreTestCase;
import org.junit.Test;
import ui.ComfirmPermissionsPageObject;
import ui.MenuSettingsPageObject;
import ui.SignUpPageObject;


public class LoginIFTSbolTest extends CoreTestCase {

    @Test
    public void testLoginIFTSbol() throws InterruptedException {
        ComfirmPermissionsPageObject ComfirmPermissionsPageObject = new ComfirmPermissionsPageObject(driver);
        MenuSettingsPageObject MenuSettingsPageObject = new MenuSettingsPageObject(driver);
        SignUpPageObject SignUpPageObject = new SignUpPageObject(driver);


        ComfirmPermissionsPageObject.confirmAgreement();
        ComfirmPermissionsPageObject.comfirmPermission();
        ComfirmPermissionsPageObject.allowPermission();
        ComfirmPermissionsPageObject.allowPermission();
        Thread.sleep(1000);
        ComfirmPermissionsPageObject.allowPermission();

        Thread.sleep(1000);
        MenuSettingsPageObject.menuSettings(1010, 159);
        MenuSettingsPageObject.chooseTestingSettings();
        MenuSettingsPageObject.chooseTogglesButton();
        MenuSettingsPageObject.searchToggles();
        MenuSettingsPageObject.inputToggleName("ATHENADEV_FAKE_VPS_ENABLED");
        MenuSettingsPageObject.activateToggle();
        MenuSettingsPageObject.closeSearchButton();
        MenuSettingsPageObject.closeSearchButton();
        MenuSettingsPageObject.backToTogglesMenu();
        MenuSettingsPageObject.backToHomeScreen();
        Thread.sleep(1000);
        MenuSettingsPageObject.menuSettings(1010, 159);
        MenuSettingsPageObject.selectServer();
        MenuSettingsPageObject.selectIFT();

        SignUpPageObject.signUp();
        SignUpPageObject.signUpByLogin();
        SignUpPageObject.clickInputLoginString();
        SignUpPageObject.inputLogin("p2pvoice4");
        SignUpPageObject.confirmLogin();
        SignUpPageObject.inputPassword();
        SignUpPageObject.inputPassword();
        SignUpPageObject.skipWarning();
    }
}

