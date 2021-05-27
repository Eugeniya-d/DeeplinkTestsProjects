package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ComfirmPermissionsPageObject extends MainPageObject{
    public ComfirmPermissionsPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String CONFIRM_AGREEMENT_BUTTON = "ru.sberbankmobile_alpha:id/confirm";
    private static final String CONTINUE_BUTTON = "ru.sberbankmobile_alpha:id/ask_permissions_button";
    private static final String ALLOW_BUTTON = "com.android.permissioncontroller:id/permission_allow_button";


    public void confirmAgreement() {
        waitForElementAndClick(By.id(CONFIRM_AGREEMENT_BUTTON),
                "Не найдена  кнопка согласиться ",
                15);
    }

    public void comfirmPermission() {
        waitForElementAndClick(By.id(CONTINUE_BUTTON),
                "Не найдена  кнопка продолжить ",
                15);
    }

    public void waitForAllowPermission() {
        waitForElementPresent(By.id(ALLOW_BUTTON),
                "Не найдена  кнопка ALLOW " ,
                15);
    }


    public void allowPermission() {
        waitForElementAndClick(By.id(ALLOW_BUTTON),
                "Не найдена  кнопка ALLOW " ,
                15);
    }
}
