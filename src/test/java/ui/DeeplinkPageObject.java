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
            WHILE_USING_APP_BUTTON = "com.android.permissioncontroller:id/permission_allow_foreground_only_button",
            DENY_CALL_BUTTON = "com.android.permissioncontroller:id/permission_deny_button",
            HANG_UP_CALL_XPATH = "//*[contains(@text, 'ПРЕРВАТЬ ЗВОНОК')]",
            LINK_HISRORY = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.TextView",
            LINK_CALL = "ru.sberbankmobile_alpha:id/assistant_list_card_cells_container";



    public void clickLink() {
        waitForElementAndClick(By.xpath(LINK_TO_MAIN) ,
                "Не открывается ссылка на главный ",
                10);
    }

    public void clickCall() {

        waitForElementAndClick(By.id(LINK_CALL) ,
                "Не открывается ссылка звонка",
                10);
    }

    public void clickHistory() {

        waitForElementAndClick(By.xpath(LINK_HISRORY) ,
                "Не открывается ссылка истории",
                10);
    }

    public void callPermission() {
        waitForElementAndClick(By.id(WHILE_USING_APP_BUTTON),
                "Невозможно нажать на кнопку разрешения звонка",
                15);
    }

    public void denyCallButton() {
        waitForElementAndClick(By.id(DENY_CALL_BUTTON),
                "Невозможно прервать звонок",
                15);
    }

    public WebElement waitForHangUpCall() {
     return   this.waitForElementPresent(By.xpath(HANG_UP_CALL_XPATH),
                "Не найден элемент прервать звонок",
                15);
    }
}
