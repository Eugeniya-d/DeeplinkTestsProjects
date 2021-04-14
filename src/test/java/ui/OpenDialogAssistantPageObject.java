package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class OpenDialogAssistantPageObject extends MainPageObject {

    public OpenDialogAssistantPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String OPEN_KEYBOARD_BUTTON = "ru.sberbankmobile_alpha:id/input_panel_keyboard_button";
    private static final String TEXT_INPUT_LINE = "ru.sberbankmobile_alpha:id/input_panel_edit_text";
    private static final String SEND_MESSAGE_BUTTON = "ru.sberbankmobile_alpha:id/kpss_button_content_image";
    private static final String VOICE_PERMISSION = "com.android.permissioncontroller:id/permission_deny_button";
    private static final String LAVASHAR = "ru.sberbankmobile_alpha:id/kpss_animated_view";

    public void selectKeyboard() {
        waitForElementAndClick(By.id(OPEN_KEYBOARD_BUTTON),
                "Кнопка клавиатуры не найдена",
                10);
    }

    public void clickInputLine() {
        waitForElementAndClick(By.id(TEXT_INPUT_LINE),
                "Не найдено поле ввода текста",
                10);
    }

    public void inputText(String inputText) {
        waitForElementAndSendKeys(By.id(TEXT_INPUT_LINE),
                "Не удалось вставить текст",
                10,
                inputText);
    }

    public void sendMessage() {
        waitForElementAndClick(By.id(SEND_MESSAGE_BUTTON),
                "Кнопка отправить не найдена",
                10);
    }
    public void voiceDeniPermission() {
        waitForElementAndClick(By.id(VOICE_PERMISSION),
                "Кнопка согласиться не найдена",
                15);
    }
    public void voiceDeniPermissionisPresent() {
        waitForElementPresent(By.id(VOICE_PERMISSION),
                "Кнопка согласиться не найдена",
                15);
    }
    public void clickLavashar() {
        waitForElementAndClick(By.id(LAVASHAR),
                "Лавашар не найден",
                15);
    }

}

