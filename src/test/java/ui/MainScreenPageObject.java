package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainScreenPageObject extends MainPageObject{
    public MainScreenPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String VOICE_ASSISTANT_BUTTON = "ru.sberbankmobile_alpha:id/image_voice_assistant";
    private static final String HOME_BUTTON = "//android.widget.FrameLayout[@content-desc='Главный, вкладка, 1 из 5']/android.widget.TextView";

    public WebElement waitForHomeButton() {
        return  this.waitForElementPresent(By.xpath(HOME_BUTTON),
                "Нет кнопки 'Главный'",
                15);
    }



    public void enterToAssistant() {
        waitForElementAndClick(By.id(VOICE_ASSISTANT_BUTTON),
                "Невозможно зайти в ассистент",
                15);
    }
}
