package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SettingsPageObject extends MainPageObject{
    public SettingsPageObject(AppiumDriver driver) {
        super(driver);
    }


    private static final String SETTINGS_BUTTON ="//*[contains(@text, 'Настройки для тестирования')]";
    private static final String TOGGLES_BUTTON ="ru.sberbankmobile_alpha:id/toggle_switcher_button";
    private static final String SEARCH_BUTTON ="android:id/search_button";
    private static final String INPUT_SEARCH ="android:id/search_src_text";
    private static final String ATHENADEV_FAKE_VPS_ENABLED_BUTTON ="ru.sberbankmobile_alpha:id/switch_view";
    private static final String CLOSE_BUTTON ="android:id/search_close_btn";
    private static final String BACK_TO_TOGGLES_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']";
    private static final String BACK_TO_HOME_SCREEN_BUTTON ="ru.sberbankmobile_alpha:id/back_button";
    private static final String SERVER_BUTTON = "//*[contains(@text, 'Server')]";
    private static final String IFT_SERVER_BUTTON = "//*[contains(@text, 'ИФТ')]";
    private static final String MENU_BUTTON= "//android.widget.ImageView[@content-desc='More options']";


    public void waitForMenuButton() {
        waitForElementPresent(By.xpath(MENU_BUTTON),
                "Не найдена  кнопка меню",
                15);
    }

    public void clickMenuButton() {
        waitForElementAndClick(By.xpath(MENU_BUTTON),
                "Не найдена  кнопка меню",
                15);
    }

    public void chooseTestingSettings() {
        waitForElementAndClick(By.xpath(SETTINGS_BUTTON),
                "Не найдена  кнопка 'Настройки для тестирования'",
                15);
    }

    public void chooseTogglesButton() {
        waitForElementAndClick(By.id(TOGGLES_BUTTON),
                "Не найдена  кнопка 'Настройки toggles'",
                15);
    }

    public void searchToggles() {
        waitForElementAndClick(By.id(SEARCH_BUTTON),
                "Не найдена  кнопка поиска по тогглам",
                15);
    }

    public void inputToggleName(String toggleName) {
        waitForElementAndSendKeys(By.id(INPUT_SEARCH),
                "Не найдена строка поиска",
                15,
                 toggleName);
    }

    public void activateToggle() {
        waitForElementAndClick(By.id(ATHENADEV_FAKE_VPS_ENABLED_BUTTON),
                "Не найдена  кнопка активации тоггла",
                15);
    }

    public void closeSearchButton() {
        waitForElementAndClick(By.id(CLOSE_BUTTON),
                "Не найдена кнопка закрыть поиск",
                15);
    }

    public void backToTogglesMenu() {
        waitForElementAndClick(By.xpath(BACK_TO_TOGGLES_BUTTON),
                "Не найдена назад",
                15);
    }

    public void backToHomeScreen() {
        swipeUpToFindElement(By.id(BACK_TO_HOME_SCREEN_BUTTON),
                "Не удалось вернуться на главную страницу");
    }

    public void selectServer() {
        waitForElementAndClick(By.xpath(SERVER_BUTTON),
                "Не найдена  кнопка SERVER",
                15);
    }

    public void selectIFT() {
        waitForElementAndClick(By.xpath(IFT_SERVER_BUTTON),
                "Не найдена  кнопка IFT",
                15);
    }
}
