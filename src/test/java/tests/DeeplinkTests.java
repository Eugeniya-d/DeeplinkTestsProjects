package tests;

import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.*;



public class DeeplinkTests extends CoreTestCase {
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
    public void testMainScreen() throws InterruptedException {
    MainScreenPageObject MainScreenPageObject = new MainScreenPageObject(driver);
    HelperPageObject HelperPageObject = new HelperPageObject(driver);
        HelperPageObject.sendLink(MAIN_SCREEN);
        HelperPageObject.tapLink();

        String buttontext = "Главный";
    Assert.assertEquals(
            "Ссылка привела не на главный экран",
            MainScreenPageObject.waitForHomeButton().getAttribute("text"),
            buttontext
    );
}

    @Test
    public void testcardReissue() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CARD_REISSUE);
        HelperPageObject.tapLink();


        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();
        String buttontext = "Перевыпуск карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел перевыпуск",
                DeeplinkPageObject.waitForCardReissueTitle().getAttribute("text"),
                buttontext
        );
    }




    @Test
    public void testCallBank() throws InterruptedException {
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject HelperPageObject = new HelperPageObject(driver);

        HelperPageObject.sendLink(CALL_BANK);
        HelperPageObject.tapLink();

        DeeplinkPageObject.denyCallButton();
    }

    @Test
    public void testHistory() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(HISTORY);
        HelperPageObject.tapLink();


        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testListNotifications() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(NOTIFICATION_LIST);
        HelperPageObject.tapLink();


        String buttontext = "Уведомления";
        Assert.assertEquals(
                "Кнопка не привела в раздел уведомления",
                DeeplinkPageObject.waitForNotificationTitle().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testPushes() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(PUSHES);
        HelperPageObject.tapLink();


        String buttontext = "Push‑уведомления";
        Assert.assertEquals(
                "Кнопка не привела в уведомления от банка",
                DeeplinkPageObject.waitForPushNotificationTitle().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testCardVisibility() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CARD_VISIBILITY);
        HelperPageObject.tapLink();


        String buttontext = "Восстановить отображение";
        Assert.assertEquals(
                "Кнопка не привела в уведомления от банка",
                DeeplinkPageObject.waitForVisibilityTitle().getAttribute("text"),
                buttontext
        );
    }



   @Test
    public void testChangePin() throws InterruptedException {
       HelperPageObject HelperPageObject = new HelperPageObject(driver);
       DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

       HelperPageObject.sendLink(CHANGE_PIN);
       HelperPageObject.tapLink();


       DeeplinkPageObject.waitForCard();
       DeeplinkPageObject.clickCard();
       DeeplinkPageObject.clickContinue();

       String buttontext = "Установка ПИН-кода";
       Assert.assertEquals(
               "Кнопка не привела в смена пин-кода",
               DeeplinkPageObject.waitForCardChangePin().getAttribute("text"),
               buttontext
       );
    }

    @Test
    public void testAutoPayments() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(AUTO_PAYMENTS);
        HelperPageObject.tapLink();


        String buttontext = "Автоплатежи и автопереводы";
        Assert.assertEquals(
                "Кнопка не привела в раздел автоплатежи",
                DeeplinkPageObject.waitForAutopayments().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testCreditCapacity() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CREDIT_CAPACITY);
        HelperPageObject.tapLink();


        String buttontext = "Узнайте свой кредитный потенциал";
        Assert.assertEquals(
                "Кнопка не привела в раздел кредитный потенциал",
                DeeplinkPageObject.waitForCreditCapacity().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testFraud() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(FRAUD);
        HelperPageObject.tapLink();


        String buttontext = "Безопасность";
        Assert.assertEquals(
                "Кнопка не привела в раздел безопасность",
                DeeplinkPageObject.waitForFraud().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testDebitCardOrder() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(DEBIT_CARD_ORDER);
        HelperPageObject.tapLink();

        String buttontext = "Дебетовые карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел дебетовые карты",
                DeeplinkPageObject.waitForDebitCard().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testCreditCardOrder() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CREDIT_CARD_ORDER);
        HelperPageObject.tapLink();


        String buttontext = "Кредитные карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел кредитные карты ",
                DeeplinkPageObject.waitForCreditCardOrder().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testCreditHistory() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CREDIT_HISTORY);
        HelperPageObject.tapLink();

        String buttontext = "Кредитная история";
        Assert.assertEquals(
                "Кнопка не привела в раздел кредитная история",
                DeeplinkPageObject.waitForCreditHistory().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testBlockCard() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CARD_BLOCK);
        HelperPageObject.tapLink();

        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }

    //Сейчас тех работы, тест и ассерты верны
    @Test
    public void testPotrebLoan() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(POTREB_LOAN);
        HelperPageObject.tapLink();


        String buttontext = "Предварительный расчет";
        Assert.assertEquals(
                "Кнопка не привела в раздел предварительный расчет",
                DeeplinkPageObject.waitForPotrebLoan().getAttribute("text"),
                buttontext
        );
    }

    //ссылка-птичка
    @Test
    public void testAutoLoan() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(AUTO_LOAN);
        HelperPageObject.tapLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }

    //Временно недоступен
    @Test
    public void testRefinLoan() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(REFIN_LOAN);
        HelperPageObject.tapLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }



    //Ссылка-птичка
    @Test
    public void testTariffs() throws InterruptedException {
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        HelperPageObject HelperPageObject = new HelperPageObject(driver);

        HelperPageObject.sendLink(TARIFFS);
        HelperPageObject.tapLink();

            String buttontext = "Блокировка карты";
            Assert.assertEquals(
                    "Кнопка не привела в раздел блокировки карты ",
                    DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                    buttontext
            );
        }






    //Проверить , добавить правильные ассерты
    @Test
    public void testAppeal() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(APPEAL);
        HelperPageObject.tapLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }



    //Проверить , добавить правильные ассерты
    @Test
    public void testStates() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(STATEMENTS_AND_REFERENCES);
        HelperPageObject.tapLink();


        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }

    //Проверить , добавить правильные ассерты// недоступен
    @Test
    public void testCreditStatements() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CREDIT_STATEMENTS);
        HelperPageObject.tapLink();


        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }


    //сервис временно не доступен, тест правильный
    @Test
    public void testOpenDeposit() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(OPEN_DEPOSIT);
        HelperPageObject.tapLink();

        String buttontext = "Вклады и счета";
        Assert.assertEquals(
                "Кнопка не привела в раздел вклады и счета",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    //ссылка-птичка
    @Test
    public void testUnblockCard() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(CARD_UNBLOCKING);
        HelperPageObject.tapLink();

        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();


        String buttontext = "Разблокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел разблокировки карты ",
                DeeplinkPageObject.waitForCardUnBlock().getAttribute("text"),
                buttontext
        );
    }

    //ссылка-птичка
    @Test
    public void testSberPay() {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(SBER_PAY);
        DeeplinkPageObject.waitForPayLink();
        DeeplinkPageObject.tapToPayLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }



 //птичка, не удалось подключить уведомления
    @Test
    public void testActivateNotifications() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(ACTIVATE_NOTIFICATION);
        HelperPageObject.tapLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    //сервис недоступен , нет проверки
    @Test
    public void testDebitStatements() throws InterruptedException {
        HelperPageObject HelperPageObject = new HelperPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        HelperPageObject.sendLink(DEBIT_STATEMENTS);
        HelperPageObject.tapLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

}

