package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class WriteAssistantPageObject extends MainPageObject {

    public WriteAssistantPageObject(AppiumDriver driver) {
        super(driver);
    }

public void openDialogWithAssistant(){
        waitForElementAndClick(By.id("ru.sberbankmobile_alpha:id/input_panel_keyboard_button"),
                "Кнопка клавиатуры не найдена",
                10);



    waitForElementAndClick(By.id("ru.sberbankmobile_alpha:id/input_panel_edit_text"),
            "Панель ввода текста не найдена",
            10);

    waitForElementAndSendKeys(By.id("ru.sberbankmobile_alpha:id/input_panel_edit_text"),
            "Панель ввода текста не найдена",
            10,
            "legacy-android-app://ru.sberbankmobile_alpha/android-app/ru.sberbankmobile_alpha/main");

    waitForElementAndClick(By.id("ru.sberbankmobile_alpha:id/kpss_button_content_image"),
            "Кнопка отправки сообщения не найдена",
            10);
    }
}

