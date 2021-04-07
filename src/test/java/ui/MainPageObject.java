package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }


    public WebElement waitForElementAndClick(By by, String errorTextMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, errorTextMessage, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By by, String errorTextMessage, long timeoutInSeconds, String value) {
        WebElement element = waitForElementPresent(by, errorTextMessage, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(By by, String errorTextMessage, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, errorTextMessage, timeoutInSeconds);
        element.clear();
        return element;
    }

    public WebElement waitForElementPresent(By by, String errorTextMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorTextMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public Boolean waitForElementNotPresent(By by, String errorTextMessage, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorTextMessage + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void tapByCoordinates(int pointToClickX, int pointToClickY) {
        TouchAction action = new TouchAction((AppiumDriver)driver);
        action.tap(PointOption.point(pointToClickX, pointToClickY)).perform();
    }

    public void swipeUp(int timeOfSwipe){
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int startY = (int) (size.height*0.8);
        int endY = (int) (size.height*0.2);

        action.press(PointOption.point(x,startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, endY)).release().perform();
    }

    public void swipeUpQuick(){
        swipeUp(200);
    }

    public void swipeUpToFindElement(By by, String errorMessage){
        driver.findElements(by);
        driver.findElements(by).size();

        while (driver.findElements(by).size()==0) {
            swipeUpQuick();
        }
        waitForElementAndClick(by,
                errorMessage,
                10);
    }
}
