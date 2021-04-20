package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DeeplinkPageObject extends MainPageObject {
    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            DENY_CALL_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
            LINK_CLICK = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout",
            BACK_TO_ASSISTANT_BUTTON = "//*[contains(@text,'Тип операции')]",
            NOTIFICATION_TITLE = "//*[contains(@text,'Уведомления')]",
            OPERATION_TYPE_BUTTON = "//*[contains(@text,'Тип операции')]";



    public WebElement waitForOperationTypePresent() {
        return waitForElementPresent(By.xpath(OPERATION_TYPE_BUTTON),
                "Нет кнопки тип операции",
                10);
    }

    public WebElement waitForNotificationTitle() {
        return waitForElementPresent(By.xpath(NOTIFICATION_TITLE),
                10);
    }

    public void clickLink() {
        waitForElementAndClick(By.xpath(LINK_CLICK),
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

}
