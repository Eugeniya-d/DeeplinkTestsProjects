package tests;

import lib.CoreTestCase;
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
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(MAIN_SCREEN);
        HelperPageObject.assertTitle("Главный");

    }

    @Test
    public void testCardReissue() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject.tapLink(CARD_REISSUE);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        HelperPageObject.assertTitle("Перевыпуск карты");
    }


    @Test
    public void testCallBank() {
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CALL_BANK);
        DeeplinkPageObject.denyCallButton();
    }

    @Test
    public void testHistory() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(HISTORY);
        HelperPageObject.assertTitle("Тип операции");
    }

    @Test
    public void testListNotifications() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(NOTIFICATION_LIST);
        HelperPageObject.assertTitle("Уведомления");
    }


    @Test
    public void testPushes() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(PUSHES);
        HelperPageObject.assertTitle("Push‑уведомления");
    }


    @Test
    public void testCardVisibility() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CARD_VISIBILITY);
        HelperPageObject.assertTitle("Восстановить отображение");
    }


    @Test
    public void testChangePin() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject.tapLink(CHANGE_PIN);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        DeeplinkPageObject.clickContinue();
        HelperPageObject.assertTitle("Установка ПИН-кода");
    }

    @Test
    public void testAutoPayments() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(AUTO_PAYMENTS);
        HelperPageObject.assertTitle("Автоплатежи и автопереводы");
    }

    @Test
    public void testCreditCapacity() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CREDIT_CAPACITY);
        HelperPageObject.assertTitle("Узнайте свой кредитный потенциал");
    }

    @Test
    public void testFraud() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(FRAUD);
        HelperPageObject.assertTitle("Безопасность");
    }


    @Test
    public void testDebitCardOrder() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(DEBIT_CARD_ORDER);
        HelperPageObject.assertTitle("Дебетовые карты");
    }

    @Test
    public void testCreditCardOrder() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CREDIT_CARD_ORDER);
        HelperPageObject.assertTitle("Кредитные карты");
    }


    @Test
    public void testCreditHistory() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CREDIT_HISTORY);
        HelperPageObject.assertTitle("Кредитная история");
    }

    @Test
    public void testBlockCard() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject.tapLink(CARD_BLOCK);
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        HelperPageObject.assertTitle("Блокировка карты");
    }

    @Test
    public void testDebitStatements() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(DEBIT_STATEMENTS);
        HelperPageObject.assertTitle("Выписки и справки");
    }

    @Test
    public void testAutoLoan() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(AUTO_LOAN);
        HelperPageObject.assertTitle("Параметры автокредита");
    }

    @Test
    public void testAppeal() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(APPEAL);
        HelperPageObject.assertTitle("Мои обращения");
    }

    @Test
    public void testRefinLoan() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(REFIN_LOAN);
        HelperPageObject.assertTitle("Рефинансирование");
    }

    @Test
    public void testActivateNotifications() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(ACTIVATE_NOTIFICATION);
        HelperPageObject.assertTitle("Подключение уведомлений");
    }

    @Test
    public void testCreditStatements() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(CREDIT_STATEMENTS);
        HelperPageObject.assertTitle("Выписки и справки");
    }

    @Test
    public void testStates() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(STATEMENTS_AND_REFERENCES);
        HelperPageObject.assertTitle("Выписки и справки");
    }


    //Сейчас тех работы, тест и ассерты верны
    @Test
    public void testPotrebLoan() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(POTREB_LOAN);
        HelperPageObject.assertTitle("Предварительный расчет");
    }

    //Ссылка-птичка
    @Test
    public void testTariffs() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(TARIFFS);
        HelperPageObject.assertTitle("Тарифы");
    }

    //сервис временно не доступен, тест правильный
    @Test
    public void testOpenDeposit() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(OPEN_DEPOSIT);
        HelperPageObject.assertTitle("Вклады и счета");
    }

    //ссылка-птичка
    @Test
    public void testSberPay() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.tapLink(SBER_PAY);
        HelperPageObject.assertTitle("Вклады и счета");
    }
}

