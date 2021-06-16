package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.*;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private String AppiumURL = "http://127.0.0.1:4723/wd/hub";


    @Before

    public void setUp() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "AndroidTestDev");
        desiredCapabilities.setCapability("platformVersion", "11.0");
        desiredCapabilities.setCapability("appPackage", "ru.sberbankmobile_alpha");
        desiredCapabilities.setCapability("appActivity", "ru.sberbankmobile.SplashActivity");
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

        driver = new AndroidDriver(new URL(AppiumURL), desiredCapabilities);
        this.openSbolIFTandAssistantDialog();
    }



    public void openSbolIFTandAssistantDialog() {
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
        SettingsPageObject.inputToggleName("ATHENADEV_FAKE_VPS_ENABLED");
        SettingsPageObject.activateToggle();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.closeSearchButton();
        SettingsPageObject.backToTogglesMenu();
        SettingsPageObject.backToHomeScreen();

        SignUpPageObject.signUpByLogin();
        SignUpPageObject.clickInputLoginString();
        SignUpPageObject.waitForInputLogin();
        SignUpPageObject.inputLogin("chatvoice4");
        SignUpPageObject.confirmLogin();
        SignUpPageObject.inputPassword();
        SignUpPageObject.waitForInputPassword();
        SignUpPageObject.inputPassword();
        SignUpPageObject.skipWarning();

        MainScreenPageObject.enterToAssistant();
        OpenDialogAssistantPageObject.selectKeyboard();
    }




    @After
    public void tearDown() {
        driver.quit();
    }
}
