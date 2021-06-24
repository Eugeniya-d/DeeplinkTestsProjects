package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.DeeplinkPageObject;
import methods.HelperMethods;
import ui.MainScreenPageObject;
import ui.OpenDialogAssistantPageObject;

public class AllDeeplinkTest extends CoreTestCase {
    private static final String
            CHANGE_PIN = "android-app://ru.sberbankmobile_alpha/digitalpin/setup?source=chatbot&internal_source=audiohelper",
            CARD_REISSUE = "android-app://ru.sberbankmobile_alpha/products/card/reissue?internal_source=audiohelper",
            CARD_BLOCK = "android-app://ru.sberbankmobile_alpha/blockcard/add?internal_source=audiohelper",
            CARD_UNBLOCKING = "android-app://ru.sberbankmobile_alpha/products/card/unblock?internal_source=audiohelper",
            DEBIT_CARD_ORDER = "android-app://ru.sberbankmobile_alpha/mdcard/mdcardrequest?internal_source=audiohelper",
            CREDIT_CARD_ORDER = "android-app://ru.sberbankmobile_alpha/creditcardorder/order?internal_source=audiohelper",
            CARD_VISIBILITY = "android-app://ru.sberbankmobile_alpha/visibilityRecovery?internal_source=audiohelper",
            SBER_PAY = "android-app://ru.sberbankmobile_alpha/sberpay/nfc/wallet?internal_source=audiohelper",
            OPEN_DEPOSIT = "android-app://ru.sberbankmobile_alpha/products/deposit?action=create&internal_source=audiohelper",
            ACTIVATE_NOTIFICATION = "android-app://ru.sberbankmobile_alpha/mobilebank/activation?internal_source=audiohelper",
            NOTIFICATION_LIST = "android-app://ru.sberbankmobile_alpha/pushes/notificationlist?internal_source=audiohelper",
            PUSHES = "android-app://ru.sberbankmobile_alpha/pushes/mobilebank?internal_source=audiohelper",
            POTREB_LOAN = "android-app://ru.sberbankmobile_alpha/consumerLoan",
            AUTO_LOAN = "android-app://ru.sberbankmobile_alpha/carloans/carloanrequest?internal_source=audiohelper",
            REFIN_LOAN = "android-app://ru.sberbankmobile_alpha/refinloan?internal_source=audiohelper",
            CREDIT_CAPACITY = "android-app://ru.sberbankmobile_alpha/creditcapacity/calculatecp?internal_source=audiohelper",
            CREDIT_HISTORY = "android-app://ru.sberbankmobile_alpha/creditreportservice?internal_source=audiohelper",
            AUTO_PAYMENTS = "android-app://ru.sberbankmobile_alpha/payments/auto_payments?internal_source=audiohelper",
            TARIFFS = "android-app://ru.sberbankmobile/android-app/ru.sberbankmobile/creditcard/tariffs",
            CALL_BANK = "android-app://ru.sberbankmobile_alpha/callbank/voip?surface=sbol_assist&operator=1&internal_source=audiohelper",
            MAIN_SCREEN = "android-app://ru.sberbankmobile_alpha/main?internal_source=audiohelper",
            HISTORY = "android-app://ru.sberbankmobile_alpha/history?internal_source=audiohelper",
            APPEAL = "android-app://ru.sberbankmobile_alpha/appeals?internal_source=audiohelper",
            FRAUD = "android-app://ru.sberbankmobile_alpha/cseducation?internal_source=audiohelper",
            STATEMENTS_AND_REFERENCES = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?internal_source=audiohelper",
            DEBIT_STATEMENTS = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?statement=DEBIT_CARD_STATEMENT&internal_source=audiohelper",
            CREDIT_STATEMENTS = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?statement=CREDIT_CARD_STATEMENT&internal_source=audiohelper";


    @Test
    public void testAllDeeplink() {
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.tapLink(MAIN_SCREEN);
        HelperMethods.assertTitle("Главный");

        MainScreenPageObject.enterToAssistant();
        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CARD_REISSUE);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        HelperMethods.assertTitle("Перевыпуск карты");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CALL_BANK);
        DeeplinkPageObject.denyCallButton();
    }

    @Test
    public void testAllDeeplink1() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(PUSHES);
        HelperMethods.assertTitle("Push‑уведомления");

        HelperMethods.tapLink(HISTORY);
        HelperMethods.assertTitle("Тип операции");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(NOTIFICATION_LIST);
        HelperMethods.assertTitle("Уведомления");
        DeeplinkPageObject.backToAssistantButton();

    }
}