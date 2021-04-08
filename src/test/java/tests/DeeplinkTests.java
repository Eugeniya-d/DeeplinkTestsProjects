package tests;

import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.*;


public class DeeplinkTests extends CoreTestCase {
    private static final String
    CHANGE_PIN = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/digitalpin/setup?source=chatbot&internal_source=audiohelper",
    CARD_REISSUE = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/products/card/reissue?internal_source=audiohelper",
    CARD_BLOCK = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/blockcard/add?internal_source=audiohelper",
    CARD_UNBLOCKING = "android-app://ru.sberbankmobile/products/card/unblock?internal_source=audiohelper",
    DEBIT_CARD_ORDER = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/mdcard/mdcardrequest?internal_source=audiohelper",
    CREDIT_CARD_ORDER = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/mdcard/mdcardrequest?internal_source=audiohelper",
    CARD_VISIBILITY = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/visibilityRecovery?internal_source=audiohelper",
    SBER_PAY = "android-app://ru.sberbankmobile/sberpay/nfc/wallet?internal_source=audiohelper",
    OPEN_DEPOSIT = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/products/deposit?action=create&internal_source=audiohelper",
    ACTIVATE_NOTIFICATION = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/mobilebank/activation?internal_source=audiohelper",
    NOTIFICATION_LIST = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/pushes/notificationlist?internal_source=audiohelper",
    PUSHES = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/pushes/mobilebank?internal_source=audiohelper",
    POTREB_LOAN = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/consumerLoan?internal_source=audiohelper",
    AUTO_LOAN = "legacy-android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/carloans/carloanrequest?internal_source=audiohelper",
    REFIN_LOAN = "android-app://ru.sberbankmobile/refinloan?internal_source=audiohelper",
    CREDIT_CAPACITY = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/creditcapacity/calculatecp?internal_source=audiohelper",
    CREDIT_HISTORY = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/creditreportservice?internal_source=audiohelper",
    AUTO_PAYMENTS = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/payments/auto_payments?internal_source=audiohelper",
    TARIFFS = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/callbank/voip?surface=sbol_assist&operator=1&internal_source=audiohelper",
    CALL_BANK = "android-app://ru.sberbankmobile_alpha/callbank/voip?surface=sbol_assist&operator=1&internal_source=audiohelper",
    MAIN_SCREEN = "\"android-app://ru.sberbankmobile_alpha/main?internal_source=audiohelper\"",
    HISTORY = "android-app://ru.sberbankmobile/history?internal_source=audiohelper",
    APPEAL = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/appeals?internal_source=audiohelper",
    FRAUD = "android-app://ru.sberbankmobile/cseducation?internal_source=audiohelper",
    STATEMENTS_AND_REFERENCES = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/StatementsAndReferences?internal_source=audiohelper",
    DEBIT_STATEMENTS = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/StatementsAndReferences?statement=DEBIT_CARD_STATEMENT&internal_source=audiohelper",
    CREDIT_STATEMENTS = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/StatementsAndReferences?statement=CREDIT_CARD_STATEMENT&internal_source=audiohelper";

@Test
    public void testMainScreen() throws InterruptedException {
    ComfirmPermissionsPageObject ComfirmPermissionsPageObject = new ComfirmPermissionsPageObject(driver);
    SettingsPageObject SettingsPageObject = new SettingsPageObject(driver);
    SignUpPageObject SignUpPageObject = new SignUpPageObject(driver);
    MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
    OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

    ComfirmPermissionsPageObject.confirmAgreement();
    ComfirmPermissionsPageObject.comfirmPermission();
    ComfirmPermissionsPageObject.allowPermission();
    ComfirmPermissionsPageObject.allowPermission();
    Thread.sleep(1000);
    ComfirmPermissionsPageObject.allowPermission();

    Thread.sleep(1000);
    SettingsPageObject.menuSettings(1010, 159);
    SettingsPageObject.chooseTestingSettings();
    SettingsPageObject.chooseTogglesButton();
    SettingsPageObject.searchToggles();
    SettingsPageObject.inputToggleName("ATHENADEV_FAKE_VPS_ENABLED");
    SettingsPageObject.activateToggle();
    SettingsPageObject.closeSearchButton();
    SettingsPageObject.closeSearchButton();
    SettingsPageObject.backToTogglesMenu();
    SettingsPageObject.backToHomeScreen();
    Thread.sleep(1000);
    SettingsPageObject.menuSettings(1010, 159);
    SettingsPageObject.selectServer();
    SettingsPageObject.selectIFT();

    SignUpPageObject.signUp();
    SignUpPageObject.signUpByLogin();
    SignUpPageObject.clickInputLoginString();
    SignUpPageObject.inputLogin("p2pvoice4");
    SignUpPageObject.confirmLogin();
    SignUpPageObject.inputPassword();
    SignUpPageObject.inputPassword();
    SignUpPageObject.skipWarning();

    String buttontext = "Главный";

    Assert.assertEquals(
            "Вход в СБОЛ ИФТ не был осуществлен",
            MainScreenPageObject.waitForHomeButton().getAttribute("text"),
            buttontext
    );

    MainScreenPageObject.enterToAssistant();
    OpenDialogAssistantPageObject.selectKeyboard();
    OpenDialogAssistantPageObject.clickInputLine();
    OpenDialogAssistantPageObject.inputText(MAIN_SCREEN);
    OpenDialogAssistantPageObject.sendMessage();
    MainScreenPageObject.enterToAssistant();
}
}
