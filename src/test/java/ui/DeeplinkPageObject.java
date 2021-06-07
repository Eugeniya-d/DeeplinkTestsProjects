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
            DENY_CALL_BUTTON = "ru.sberbankmobile_alpha:id/ip_call_activity_hang_up_container",
            NOTIFICATION_TITLE = "//*[contains(@text,'Уведомления')]",
            OPERATION_TYPE_BUTTON = "//*[contains(@text,'Тип операции')]",
            DEBIT_SATEMENTS_TITLE = "//*[contains(@text,'Выписки и справки')]",
            REFIN_TITLE = "//*[contains(@text,'Рефинансирование')]",
            CARD = "ru.sberbankmobile_alpha:id/product_basic_field",
            CARD_REISSUE_TITLE = "//*[contains(@text,'Перевыпуск карты')]",
            ACTIVATE_NOTIFICATION_TITLE = "//*[contains(@text,'Подключение уведомлений')]",
            AUTO_LOAN_TITLE = "//*[contains(@text,'Параметры автокредита')]",
            APPEAL_TITLE = "//*[contains(@text,'Мои обращения')]",
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
            DEBIT_CARD_ORDER_TITLE = "//*[contains(@text,'Дебетовые карты')]",
            CREDIT_CARD_ORDER_TITLE = "//*[contains(@text,'Кредитные карты')]",
            CREDIT_HISTORY = "//*[contains(@text,'Кредитная история')]",
            BACK_TO_ASSISTANT = "//android.widget.ImageButton[@content-desc='Navigate up']",
            LINK_CLICK1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            LINK_CLICK = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout";


    public WebElement waitForOperationTypePresent() {
        return waitForElementPresent(By.xpath(OPERATION_TYPE_BUTTON),
                "Нет кнопки тип операции",
                40);
    }

    public WebElement waitForActivateNotification() {
        return waitForElementPresent(By.xpath(ACTIVATE_NOTIFICATION_TITLE),
                "Нет кнопки тип операции",
                40);
    }

    public WebElement waitForDebitAndStatements() {
        return waitForElementPresent(By.xpath(DEBIT_SATEMENTS_TITLE),
                "Нет кнопки тип операции",
                40);
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
        waitForElementAndClick(By.xpath(LINK_CLICK),
                "Не открывается ссылка",
                10);
    }

    public void link() {
        if (driver.findElement(By.xpath(LINK_CLICK)).isDisplayed()) {
            this.clickLink();
        }
    }

    public void link1() {
        if (driver.findElement(By.xpath(LINK_CLICK1)).isDisplayed()) {
            this.clickLink1();
        }
    }

    private void clickLink1() {
        waitForElementAndClick(By.xpath(LINK_CLICK1),
                "Не открывается ссылка",
                10);
    }

    public void denyCallButton() {
        waitForElementAndClick(By.id(DENY_CALL_BUTTON),
                "Невозможно прервать звонок",
                15);
    }

    public void backToAssistantButton() {
        waitForElementAndClick(By.xpath(BACK_TO_ASSISTANT),
                "Не найдена кнопка возврата в ассистент",
                10);
    }

    public WebElement waitForCardReissueTitle() {
        return waitForElementPresent(By.xpath(CARD_REISSUE_TITLE),
                20);
    }

    public WebElement waitForCardChangePin() {
        return waitForElementPresent(By.xpath(CARD_CHANGE_PIN_TITLE),
                20);
    }

    public WebElement waitForPushNotificationTitle() {
        return waitForElementPresent(By.xpath(PUSH_NOTIFICATION_TITLE),
                20);
    }

    public WebElement waitForVisibilityTitle() {
        return waitForElementPresent(By.xpath(CARD_VISIBILITY_TITLE),
                20);
    }

    public WebElement waitForDepositTitle() {
        return waitForElementPresent(By.xpath(DEPOSIT_TITLE),
                20);
    }

    public WebElement waitForCardBlock() {
        return waitForElementPresent(By.xpath(CARD_BLOCK),
                20);
    }

    public WebElement waitForAutoLoan() {
        return waitForElementPresent(By.xpath(AUTO_LOAN_TITLE),
                20);
    }

    public WebElement waitForCardUnBlock() {
        return waitForElementPresent(By.xpath(CARD_UNBLOCK),
                20);
    }

    public WebElement waitForPotrebLoan() {
        return waitForElementPresent(By.xpath(POTREB_LOAN_TITLE),
                40);
    }

    public WebElement waitForAutopayments() {
        return waitForElementPresent(By.xpath(AUTOPAYMENTS_TITLE),
                20);
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

    public WebElement waitForDebitCard() {
        return waitForElementPresent(By.xpath(DEBIT_CARD_ORDER_TITLE),
                10);
    }

    public WebElement waitForCreditCardOrder() {
        return waitForElementPresent(By.xpath(CREDIT_CARD_ORDER_TITLE),
                10);
    }

    public WebElement waitForCreditHistory() {
        return waitForElementPresent(By.xpath(CREDIT_HISTORY),
                10);
    }

    public WebElement waitForAppeal() {
        return waitForElementPresent(By.xpath(APPEAL_TITLE),
                10);
    }

    public WebElement  waitForRefin() {
        return waitForElementPresent(By.xpath(REFIN_TITLE),
                10);
    }

    public WebElement waitForStatments() {
        return waitForElementPresent(By.xpath(DEBIT_SATEMENTS_TITLE),
                10);
    }
}
