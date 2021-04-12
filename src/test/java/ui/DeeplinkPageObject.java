package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DeeplinkPageObject extends MainPageObject {
    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
           // LINK_TO_MAIN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout",
            LINK_TPL = "//*[contains(@text, '{LINK}')]",
            WHILE_USING_BANK_BUTTON = "com.android.permissioncontroller:id/permission_allow_foreground_only_button";

    /* TEMPLATES METHODS */
    public static String getLink(String link) {
        return LINK_TPL.replace("{LINK}", link);
    }
    /* TEMPLATES METHODS */


    public void clickLink(String link) {
        String getLink = getLink(link);
        this.waitForElementAndClick(By.xpath(getLink),
                "Cannot find title with name " + link,
                10);
    }

}
