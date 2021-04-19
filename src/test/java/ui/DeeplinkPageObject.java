package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeeplinkPageObject extends MainPageObject {
    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            LINK_TO_MAIN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout",
            DENY_CALL_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
            LINK_HISRORY = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            LINK_CALL = "ru.sberbankmobile_alpha:id/assistant_list_card_cells_container",
            LINK_CARD_VISIBILITY = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            BACK_TO_ASSISTANT_BUTTON = "//*[contains(@text,'Тип операции')]",
            OPERATION_TYPE_BUTTON = "//*[contains(@text,'Тип операции')]";


    public void clickLink() {
        waitForElementAndClick(By.xpath(LINK_TO_MAIN),
                "Не открывается ссылка на главный ",
                10);
    }

    public void waitForLink() {
        waitForElementPresent(By.id(LINK_CALL),
                "Нет ссылки на главный ",
                10);
    }

    public WebElement waitForOperationTypePresent() {
        return waitForElementPresent(By.xpath(OPERATION_TYPE_BUTTON),
                "Нет кнопки тип операции",
                10);
    }

    public void clickCall() {

        waitForElementAndClick(By.id(LINK_CALL),
                "Не открывается ссылка звонка",
                10);
    }

    public void clickHistory() {
        waitForElementAndClick(By.xpath(LINK_HISRORY),
                "Не открывается ссылка истории",
                10);
    }


    public void clickCardVisibility() {
        waitForElementAndClick(By.xpath(LINK_CARD_VISIBILITY),
                "Не открывается ссылка видимости карт",
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

}
