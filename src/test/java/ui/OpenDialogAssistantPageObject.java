package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class OpenDialogAssistantPageObject extends MainPageObject {

    public OpenDialogAssistantPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String OPEN_KEYBOARD_BUTTON = "ru.sberbankmobile_alpha:id/input_panel_keyboard_button";
    private static final String TEXT_INPUT_LINE = "ru.sberbankmobile_alpha:id/input_panel_edit_text";
    private static final String SEND_MESSAGE_BUTTON = "ru.sberbankmobile_alpha:id/kpss_button_content_image";


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
}
