package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SbolMainScreenPageObject extends MainPageObject{
    public SbolMainScreenPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String VOICE_ASSISTANT_BUTTON = "//android.widget.FrameLayout[@content-desc='Ассистент, вкладка, 3 из 5']/android.view.View";



    public void enterToAssistant() {
        waitForElementAndClick(By.id(VOICE_ASSISTANT_BUTTON),
                "Не кнопка подтверждения",
                15);
    }
}
