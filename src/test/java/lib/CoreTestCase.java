package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.*;

import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private String AppiumURL = "http://127.0.0.1:4723/wd/hub";


    @BeforeAll

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


    public void openSbolIFTandAssistantDialog() throws InterruptedException {
        ComfirmPermissionsPageObject ComfirmPermissionsPageObject = new ComfirmPermissionsPageObject(driver);
        SettingsPageObject SettingsPageObject = new SettingsPageObject(driver);
        SignUpPageObject SignUpPageObject = new SignUpPageObject(driver);
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        ComfirmPermissionsPageObject.confirmAgreement();
        ComfirmPermissionsPageObject.comfirmPermission();
        ComfirmPermissionsPageObject.allowPermission();
        ComfirmPermissionsPageObject.allowPermission();
        Thread.sleep(1000);
        ComfirmPermissionsPageObject.allowPermission();

        Thread.sleep(1000);
        SettingsPageObject.menuSettings(1010, 159);
        SettingsPageObject.selectServer();
        SettingsPageObject.selectIFT();
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

        SignUpPageObject.signUpByLogin();
        SignUpPageObject.clickInputLoginString();
        SignUpPageObject.inputLogin("chatbotvoice");
        SignUpPageObject.confirmLogin();
        SignUpPageObject.inputPassword();
        Thread.sleep(1000);
        SignUpPageObject.inputPassword();
        SignUpPageObject.skipWarning();

        String buttontext = "Главный";

        Assert.assertEquals(
                "Вход в СБОЛ ИФТ не был осуществлен",
                MainScreenPageObject.waitForHomeButton().getAttribute("text"),
                buttontext
        );
        MainScreenPageObject.enterToAssistant();
       /* if (driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).isDisplayed()){
            OpenDialogAssistantPageObject.voiceDeniPermission();
        }*/
        OpenDialogAssistantPageObject.selectKeyboard();
    }




    @AfterAll
    public void tearDown() throws Exception {
        driver.quit();
    }
}
