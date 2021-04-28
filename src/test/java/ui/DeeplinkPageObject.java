package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.FileStore;


public class DeeplinkPageObject extends MainPageObject {



    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            DENY_CALL_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
            LINK_CLICK1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            BACK_TO_ASSISTANT_BUTTON = "//*[contains(@text,'Тип операции')]",
            NOTIFICATION_TITLE = "//*[contains(@text,'Уведомления')]",
            OPERATION_TYPE_BUTTON = "//*[contains(@text,'Тип операции')]",
            CARD = "ru.sberbankmobile_alpha:id/product_basic_field",
            CARD_REISSUE_TITLE = "//*[contains(@text,'Перевыпуск карты')]",
            CONTINUE_BUTTON = "android:id/button1",
            CARD_CHANGE_PIN_TITLE = "//*[contains(@text,'Установка ПИН-кода')]",
            PUSH_NOTIFICATION_TITLE = "//*[contains(@text,'Push‑уведомления')]",
            CARD_VISIBILITY_TITLE = "//*[contains(@text,'Восстановить отображение')]",
            DEPOSIT_TITLE = "//*[contains(@text,'Вклады и счета')]",
            CARD_UNBLOCK = "//*[contains(@text,'Разблокировка карты')]",
            CARD_BLOCK = "//*[contains(@text,'Блокировка карты')]",
            POTREB_LOAN_TITLE = "//*[contains(@text,'Предварительный расчет')]",
            AUTOPAYMENTS_TITLE = "//*[contains(@text,'Автоплатежи и автопереводы')]",
            CREDIT_CAPACITY = "//*[contains(@text,'Узнайте свой кредитный потенциал')]",
            FRAUD = "//*[contains(@text,'Безопасность')]",
            LINK_CLICK = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout";

    public WebElement waitForOperationTypePresent() {
        return waitForElementPresent(By.xpath(OPERATION_TYPE_BUTTON),
                "Нет кнопки тип операции",
                10);
    }


    public void waitForCard() {
        waitForElementPresent(By.id(CARD),
                "Нет кнопки тип операции",
                10);
    }

    public void clickCard() {
        waitForElementAndClick(By.id(CARD),
                "Не открывается ссылка",
                10);
    }

    public void clickContinue() {
        waitForElementAndClick(By.id(CONTINUE_BUTTON),
                "Не возможно нажать продолжить",
                10);
    }


    public void clickLink() {
        waitForElementAndClick(By.xpath(LINK_CLICK1),
                "Не открывается ссылка",
                10);
    }


    public void denyCallButton() {
        waitForElementAndClick(By.id(DENY_CALL_BUTTON),
                "Невозможно прервать звонок",
                15);
    }

    public void backToAssistant() {
        waitForElementAndClick(By.xpath(BACK_TO_ASSISTANT_BUTTON),
                "Не найдена кнопка возврата в ассистент",
                10);
    }

    public WebElement waitForCardReissueTitle() {
        return waitForElementPresent(By.xpath(CARD_REISSUE_TITLE),
                10);
    }

    public WebElement waitForCardChangePin() {
        return waitForElementPresent(By.xpath(CARD_CHANGE_PIN_TITLE),
                10);
    }

    public WebElement waitForPushNotificationTitle() {
        return waitForElementPresent(By.xpath(PUSH_NOTIFICATION_TITLE),
                10);
    }

    public WebElement waitForVisibilityTitle() {
        return waitForElementPresent(By.xpath(CARD_VISIBILITY_TITLE),
                10);
    }

    public WebElement waitForDepositTitle() {
        return waitForElementPresent(By.xpath(DEPOSIT_TITLE),
                10);
    }

    public WebElement waitForCardBlock() {
        return waitForElementPresent(By.xpath(CARD_BLOCK),
                10);
    }

    public WebElement waitForCardUnBlock() {
        return waitForElementPresent(By.xpath(CARD_UNBLOCK),
                10);
    }

    public WebElement waitForPotrebLoan() {
        return waitForElementPresent(By.xpath(POTREB_LOAN_TITLE),
                15);
    }

    public WebElement waitForAutopayments() {
        return waitForElementPresent(By.xpath(AUTOPAYMENTS_TITLE),
                15);
    }

    public WebElement waitForCreditCapacity() {
        return waitForElementPresent(By.xpath(CREDIT_CAPACITY),
                15);
    }

    public WebElement waitForNotificationTitle() {
        return waitForElementPresent(By.xpath(NOTIFICATION_TITLE),
                10);
    }

    public WebElement waitForFraud() {
        return waitForElementPresent(By.xpath(FRAUD),
                10);
    }
}
