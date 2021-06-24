package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import methods.HelperMethods;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

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

    }





    @After
    public void tearDown() {
        driver.quit();
    }
}
