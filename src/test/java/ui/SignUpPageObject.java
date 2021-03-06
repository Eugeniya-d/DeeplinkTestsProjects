package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class SignUpPageObject extends MainPageObject {


    public SignUpPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static final String SIGN_UP_BY_CARD_BUTTON = "//*[contains(@text, 'Войти по номеру карты')]";
    private static final String SIGN_UP_BY_LOGIN_BUTTON = "//*[contains(@text, 'Войти по логину СберБанк Онлайн')]";
    private static final String ENTER_BUTTON = "ru.sberbankmobile_alpha:id/enter_button";
    private static final String LOGIN_BUTTON = "//*[contains(@text, 'Логин')]";
    private static final String SKIP_BUTTON = "ru.sberbankmobile_alpha:id/skip_button";
    private static final String INPUT_PASSWORD = "//*[contains(@text, 'Придумайте пароль')]";

    private static final String ONE = "ru.sberbankmobile_alpha:id/keyboard_number_1";
    private static final String ONE1 = "//android.widget.FrameLayout[@content-desc='1']";
    private static final String TWO = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_2']";
    private static final String THREE = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_3']";
    private static final String FOUR = "ru.sberbankmobile_alpha:id/keyboard_number_4";
    private static final String FIVE = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_5']";
    private static final String SIX = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_6']";
    private static final String SEVEN = "ru.sberbankmobile_alpha:id/keyboard_number_7";
    private static final String EIGHT = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_8']";
    private static final String NINE = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_9']";
    private static final String ZER0 = "//*[@resource-id ='ru.sberbankmobile_alpha:id/keyboard_number_0']";


    public void signUp() {
        waitForElementAndClick(By.xpath(SIGN_UP_BY_CARD_BUTTON),
                "Не найдена кнопка 'Войти по карте'",
                15);
    }


    public void signUpByLogin() {
        waitForElementAndClick(By.xpath(SIGN_UP_BY_LOGIN_BUTTON),
                "Не найдена кнопка 'Войти по логину'",
                15);
    }


    public void clickInputLoginString() {
        waitForElementAndClick(By.xpath(LOGIN_BUTTON),
                "Не найдена строка для введения логина",
                15);
    }

    public void waitForInputLogin() {
        waitForElementPresent(By.xpath(LOGIN_BUTTON),
                "Не найдена кнопка логин",
                15);
    }
    
    public void inputLogin(String login) {
        waitForElementAndSendKeys(By.xpath(LOGIN_BUTTON),
                "Невозможно ввести логин",
                15,
                 login);
    }

    public void confirmLogin() {
        waitForElementAndClick(By.id(ENTER_BUTTON),
                "Не кнопка подтверждения",
                15);
    }


    public void inputPassword(){
        waitForElementAndClick(By.xpath(ONE1),
                "Не найдена цифра 1",
                15);
        waitForElementAndClick(By.id(FOUR),
                "Не найдена цифра 4",
                15);
        waitForElementAndClick(By.id(SEVEN),
                "Не найдена цифра 7",
                15);
        waitForElementAndClick(By.xpath(ONE1),
                "Не найдена цифра 1",
                15);
        waitForElementAndClick(By.id(FOUR),
                "Не найдена цифра 4",
                15);
    }

    public void skipWarning() {
        waitForElementAndClick(By.id(SKIP_BUTTON),
                "Не найдена кнопка пропустить",
                40);
    }

    public void waitForInputPassword() {
        waitForElementPresent(By.xpath(INPUT_PASSWORD),
                "Не найдено 'Придумайте пароль'",
                10);
    }
}
