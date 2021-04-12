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
            LINK_TPL = "//*[contains(@text, '{LINK}')]",
            WHILE_USING_APP_BUTTON = "com.android.permissioncontroller:id/permission_allow_foreground_only_button",
            HANG_UP_CALL = "ru.sberbankmobile_alpha:id/ip_call_activity_hang_up_container",
            HANG_UP_CALL_XPATH = "//*[contains(@text, 'ПРЕРВАТЬ ЗВОНОК')]",
            LINK_CALL = "//*[contains(@text, 'android-app://ru.sberbankmobile_alpha/callbank/voip?surface=sbol_assist&operator=1&internal_source=audiohelper')]";


    /* TEMPLATES METHODS */
    public static String getLink(String link) {
        return LINK_TPL.replace("{LINK}", link);
    }
    /* TEMPLATES METHODS */


    public void clickLink(String link) {
        String getLink = getLink(link);
        waitForElementAndClick(By.xpath(link) ,
                "Не открывается ссылка " + link,
                10);
    }


    public void clickMain() {

        waitForElementAndClick(By.xpath(LINK_TO_MAIN) ,
                "Не открывается ссылка на главный ",
                10);
    }


    public void callPermission() {
        waitForElementAndClick(By.id(WHILE_USING_APP_BUTTON),
                "Невозможно нажать на кнопку разрешения звонка",
                15);
    }

    public void hangUpCall() {
        waitForElementAndClick(By.id(HANG_UP_CALL),
                "Невозможно прервать звонок",
                15);
    }

    public WebElement waitForHangUpCall() {
     return   this.waitForElementPresent(By.xpath(HANG_UP_CALL_XPATH),
                "Не найден элемент прервать звонок",
                15);
    }
}
