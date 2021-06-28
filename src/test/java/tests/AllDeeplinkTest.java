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
            DEBIT_CARD_ORDER = "android-app://ru.sberbankmobile_alpha/mdcard/mdcardrequest?internal_source=audiohelper",
            CREDIT_CARD_ORDER = "android-app://ru.sberbankmobile_alpha/creditcardorder/order?internal_source=audiohelper",
            CARD_VISIBILITY = "android-app://ru.sberbankmobile_alpha/visibilityRecovery?internal_source=audiohelper",
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
            CALL_BANK = "android-app://ru.sberbankmobile_alpha/callbank/voip?surface=sbol_assist&operator=1&internal_source=audiohelper",
            MAIN_SCREEN = "android-app://ru.sberbankmobile_alpha/main?internal_source=audiohelper",
            HISTORY = "android-app://ru.sberbankmobile_alpha/history?internal_source=audiohelper",
            APPEAL = "android-app://ru.sberbankmobile_alpha/appeals?internal_source=audiohelper",
            FRAUD = "android-app://ru.sberbankmobile_alpha/cseducation?internal_source=audiohelper",
            STATEMENTS_AND_REFERENCES = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?internal_source=audiohelper",
            DEBIT_STATEMENTS = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?statement=DEBIT_CARD_STATEMENT&internal_source=audiohelper",
            CREDIT_STATEMENTS = "android-app://ru.sberbankmobile_alpha/StatementsAndReferences?statement=CREDIT_CARD_STATEMENT&internal_source=audiohelper";


    @Test
    public void testMainScreen_CardReissue_CallBank() {
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
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
    public void testPushes_NotificationList_History() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(PUSHES);
        HelperMethods.assertTitle("Push‑уведомления");
        DeeplinkPageObject.backToAssistantButton();


        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(NOTIFICATION_LIST);
        HelperMethods.assertTitle("Уведомления");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(HISTORY);
        HelperMethods.assertTitle("Тип операции");
    }

    @Test
    public void testCardVisibility_AutoPayments_ChangePin() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(CARD_VISIBILITY);
        HelperMethods.assertTitle("Восстановить отображение");
        DeeplinkPageObject.backToAssistantButton();


        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(AUTO_PAYMENTS);
        HelperMethods.assertTitle("Автоплатежи и автопереводы");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CHANGE_PIN);
        DeeplinkPageObject.waitForCard();
        HelperMethods.assertTitle("Выберите карту для установки ПИН-кода");
    }

    @Test
    public void testCreditCapacity_Fraud_DebCardOrder() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CREDIT_CAPACITY);
        HelperMethods.assertTitle("Узнайте свой кредитный потенциал");
        DeeplinkPageObject.backToAssistantButton();

        MainScreenPageObject.enterToAssistant();
        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(FRAUD);
        HelperMethods.assertTitle("Безопасность");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(DEBIT_CARD_ORDER);
        HelperMethods.assertTitle("Дебетовые карты");
    }

    public void testCrCarDOrder_CreditHistory_CardBlock() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(CREDIT_CARD_ORDER);
        HelperMethods.assertTitle("Кредитные карты");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CREDIT_HISTORY);
        HelperMethods.assertTitle("Кредитная история");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CARD_BLOCK);
        DeeplinkPageObject.waitForCard();
        HelperMethods.assertTitle("Карты");
    }

    public void testAutoLoan_Appeal_DebitStatements() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(AUTO_LOAN);
        HelperMethods.assertTitle("Автокредит");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(APPEAL);
        HelperMethods.assertTitle("Мои обращения");
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(DEBIT_STATEMENTS);
        HelperMethods.assertTitle("Выписка");
    }

    public void testRefinLoan_CreditStatements_ActivateNotification() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(REFIN_LOAN);
        HelperMethods.assertTitle("Рефинансирование");;
        DeeplinkPageObject.backToAssistantButton();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(CREDIT_STATEMENTS);
        HelperMethods.assertTitle("Выписки и справки");
        DeeplinkPageObject.backButtonClick();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(ACTIVATE_NOTIFICATION);
        HelperMethods.closePopUp();
    }

    public void testOpenDeposit_PotrebLoan_StatementsAndReferences() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(OPEN_DEPOSIT);
        HelperMethods.assertTitle("Подбор вклада");
        DeeplinkPageObject.backButtonClick();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(POTREB_LOAN);
        HelperMethods.assertTitle("Предварительный расчёт");
        DeeplinkPageObject.backButtonClick();

        OpenDialogAssistantPageObject.selectKeyboard();
        HelperMethods.tapLink(STATEMENTS_AND_REFERENCES);
        HelperMethods.assertTitle("Выписки и справки");
    }
}
