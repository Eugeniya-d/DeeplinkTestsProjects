package tests;

import lib.CoreTestCase;
import methods.HelperMethods;
import org.junit.Test;
import ui.*;


public class DeeplinkTests extends CoreTestCase {
    private static final String
            CHANGE_PIN = "android-app://ru.sberbankmobile_alpha/digitalpin/setup?source=chatbot&internal_source=audiohelper",
            CARD_REISSUE = "android-app://ru.sberbankmobile_alpha/products/card/reissue?internal_source=audiohelper",
            CARD_BLOCK = "android-app://ru.sberbankmobile_alpha/blockcard/add?internal_source=audiohelper",
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
    public void testMainScreen() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(MAIN_SCREEN);
        HelperMethods.assertTitle("Главный");

    }

    @Test
    public void testCardReissue() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CARD_REISSUE);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        HelperMethods.assertTitle("Перевыпуск карты");
    }


    @Test
    public void testCallBank() {
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CALL_BANK);
        DeeplinkPageObject.denyCallButton();
    }

    @Test
    public void testHistory() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(HISTORY);
        HelperMethods.assertTitle("Тип операции");
    }

    @Test
    public void testListNotifications() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(NOTIFICATION_LIST);
        HelperMethods.assertTitle("Уведомления");
    }


    @Test
    public void testPushes() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(PUSHES);
        HelperMethods.assertTitle("Push‑уведомления");
    }


    @Test
    public void testCardVisibility() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CARD_VISIBILITY);
        HelperMethods.assertTitle("Восстановить отображение");
    }


    @Test
    public void testChangePin() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CHANGE_PIN);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        DeeplinkPageObject.clickContinue();
        HelperMethods.assertTitle("Установка ПИН-кода");
    }

    @Test
    public void testAutoPayments() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(AUTO_PAYMENTS);
        HelperMethods.assertTitle("Автоплатежи и автопереводы");
    }

    @Test
    public void testCreditCapacity() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CREDIT_CAPACITY);
        HelperMethods.assertTitle("Узнайте свой кредитный потенциал");
    }

    @Test
    public void testFraud() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(FRAUD);
        HelperMethods.assertTitle("Безопасность");
    }


    @Test
    public void testDebitCardOrder() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(DEBIT_CARD_ORDER);
        HelperMethods.assertTitle("Дебетовые карты");
    }

    @Test
    public void testCreditCardOrder() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CREDIT_CARD_ORDER);
        HelperMethods.assertTitle("Кредитные карты");
    }


    @Test
    public void testCreditHistory() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CREDIT_HISTORY);
        HelperMethods.assertTitle("Кредитная история");
    }

    @Test
    public void testBlockCard() {
        HelperMethods HelperMethods = new HelperMethods(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CARD_BLOCK);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        HelperMethods.assertTitle("Блокировка карты");
    }

    @Test
    public void testDebitStatements() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(DEBIT_STATEMENTS);
        HelperMethods.assertTitle("Выписки и справки");
    }

    @Test
    public void testAutoLoan() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(AUTO_LOAN);
        HelperMethods.assertTitle("Параметры автокредита");
    }

    @Test
    public void testAppeal() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(APPEAL);
        HelperMethods.assertTitle("Мои обращения");
    }

    @Test
    public void testRefinLoan() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(REFIN_LOAN);
        HelperMethods.assertTitle("Рефинансирование");
    }

    @Test
    public void testActivateNotifications() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(ACTIVATE_NOTIFICATION);
        HelperMethods.assertTitle("Подключение уведомлений");
    }

    @Test
    public void testCreditStatements() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(CREDIT_STATEMENTS);
        HelperMethods.assertTitle("Выписки и справки");
    }

    @Test
    public void testStates() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("chatbotvoice");
        HelperMethods.tapLink(STATEMENTS_AND_REFERENCES);
        HelperMethods.assertTitle("Выписки и справки");
    }


    //Сейчас тех работы, тест и ассерты верны
    @Test
    public void testPotrebLoan() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(POTREB_LOAN);
        HelperMethods.assertTitle("Предварительный расчет");
    }


    //сервис временно не доступен, тест правильный
    @Test
    public void testOpenDeposit() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(OPEN_DEPOSIT);
        HelperMethods.assertTitle("Вклады и счета");
    }

    //Ссылка-птичка
    @Test
    public void testTariffs() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(TARIFFS);
        HelperMethods.assertTitle("Тарифы");
    }

    
    //ссылка-птичка
    @Test
    public void testSberPay() {
        HelperMethods HelperMethods = new HelperMethods(driver);

        HelperMethods.openSbolIFTandAssistantDialog("2797227457kp");
        HelperMethods.tapLink(SBER_PAY);
        HelperMethods.assertTitle("Вклады и счета");
    }
}

