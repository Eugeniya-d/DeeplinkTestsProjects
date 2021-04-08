package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DeeplinkPageObject extends MainPageObject {
    public DeeplinkPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String
            LINK_TO_MAIN = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout/androidx.cardview.widget.CardView/android.widget.LinearLayout";


    public void clickMainLink() {
        waitForElementAndClick(By.xpath(LINK_TO_MAIN),
                "Не удалось перейти по ссылке MAIN",
                15);
    }

}
