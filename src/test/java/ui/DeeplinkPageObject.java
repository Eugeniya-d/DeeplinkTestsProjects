package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class DeeplinkPageObject extends MainPageObject {


    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            DENY_CALL_BUTTON = "ru.sberbankmobile_alpha:id/ip_call_activity_hang_up_container",
            OPERATION_TYPE_BUTTON = "//*[contains(@text,'Тип операции')]",
            CARD = "ru.sberbankmobile_alpha:id/product_basic_field",
            CARD_REISSUE_TITLE = "//*[contains(@text,'Перевыпуск карты')]",
            CONTINUE_BUTTON = "android:id/button1",
            BACK_TO_ASSISTANT = "//android.widget.ImageButton[@content-desc='Navigate up']",
            TITLE_TEXT_TPL = "//*[contains(@text, '{TITLETEXT}')]",
            LINK_CLICK1 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            LINK_CLICK = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[4]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout";

    /* TEMPLATES METHODS */
    private static String getTitleText(String titleText) {
        return TITLE_TEXT_TPL.replace("{TITLETEXT}", titleText);
    }
    /* TEMPLATES METHODS */


    public WebElement waitForTitlePresent(String titleText) {
        String getTitleText = getTitleText(titleText);
     return this.waitForElementPresent(By.xpath(getTitleText),
              "Не найден заголовок " + titleText,
                10);
    }


    public WebElement waitForOperationTypePresent() {
        return waitForElementPresent(By.xpath(OPERATION_TYPE_BUTTON),
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
}
