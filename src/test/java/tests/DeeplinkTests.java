package tests;

import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
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
    POTREB_LOAN = "android-app://ru.sberbankmobile_alpha/consumerLoan?internal_source=audiohelper",
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
    OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
    DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

    OpenDialogAssistantPageObject.clickInputLine();
    OpenDialogAssistantPageObject.inputText(MAIN_SCREEN);
    OpenDialogAssistantPageObject.sendMessage();
    OpenDialogAssistantPageObject.sendMessage();

    Thread.sleep(1000);
    OpenDialogAssistantPageObject.denyAssistantNotification();
    DeeplinkPageObject.clickLink();

    String buttontext = "Главный";
    Assert.assertEquals(
            "Ссылка привела не на главный экран",
            MainScreenPageObject.waitForHomeButton().getAttribute("text"),
            buttontext
    );
}

    @Test
    public void testcardReissue() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CARD_REISSUE);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        OpenDialogAssistantPageObject.denyAssistantNotification();
        DeeplinkPageObject.clickLink();


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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CALL_BANK);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        OpenDialogAssistantPageObject.denyAssistantNotification();
        DeeplinkPageObject.clickLink();
        DeeplinkPageObject.denyCallButton();
    }

    @Test
    public void testHistory() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(HISTORY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        OpenDialogAssistantPageObject.denyAssistantNotification();
        DeeplinkPageObject.clickLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testListNotifications() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(NOTIFICATION_LIST);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        OpenDialogAssistantPageObject.denyAssistantNotification();
        DeeplinkPageObject.clickLink();

        String buttontext = "Уведомления";
        Assert.assertEquals(
                "Кнопка не привела в раздел уведомления",
                DeeplinkPageObject.waitForNotificationTitle().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testPushes() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(PUSHES);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();


        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Push‑уведомления";
        Assert.assertEquals(
                "Кнопка не привела в уведомления от банка",
                DeeplinkPageObject.waitForPushNotificationTitle().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testCardVisibility() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CARD_VISIBILITY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        DeeplinkPageObject.clickLink();

        String buttontext = "Восстановить отображение";
        Assert.assertEquals(
                "Кнопка не привела в уведомления от банка",
                DeeplinkPageObject.waitForVisibilityTitle().getAttribute("text"),
                buttontext
        );
    }



   @Test
    public void testChangePin() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CHANGE_PIN);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

       Thread.sleep(1000);
       try {
           OpenDialogAssistantPageObject.denyAssistantNotification();
       } catch (NoSuchElementException e){
           System.out.println(e.getMessage());
       }

       DeeplinkPageObject.clickLink();
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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(AUTO_PAYMENTS);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Автоплатежи и автопереводы";
        Assert.assertEquals(
                "Кнопка не привела в раздел автоплатежи",
                DeeplinkPageObject.waitForAutopayments().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testCreditCapacity() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CREDIT_CAPACITY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Узнайте свой кредитный потенциал";
        Assert.assertEquals(
                "Кнопка не привела в раздел кредитный потенциал",
                DeeplinkPageObject.waitForCreditCapacity().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testFraud() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(FRAUD);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Безопасность";
        Assert.assertEquals(
                "Кнопка не привела в раздел безопасность",
                DeeplinkPageObject.waitForFraud().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testDebitCardOrder() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(DEBIT_CARD_ORDER);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(3000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Дебетовые карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел дебетовые карты",
                DeeplinkPageObject.waitForDebitCard().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testCreditCardOrder() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CREDIT_CARD_ORDER);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Кредитные карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел кредитные карты ",
                DeeplinkPageObject.waitForCreditCardOrder().getAttribute("text"),
                buttontext
        );
    }

    //Сейчас тех работы, тест и ассерты верны
    @Test
    public void testPotrebLoan() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(POTREB_LOAN);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Предварительный расчет";
        Assert.assertEquals(
                "Кнопка не привела в раздел предварительный расчет",
                DeeplinkPageObject.waitForPotrebLoan().getAttribute("text"),
                buttontext
        );
    }

    //Проверить , добавить правильные ассерты
    @Test
    public void testAutoLoan() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(AUTO_LOAN);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }

    //Проверить , добавить правильные ассерты
    @Test
    public void testRefinLoan() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(REFIN_LOAN);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(TARIFFS);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }



    //Проверить , добавить правильные ассерты
    @Test
    public void testCreditHistory() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CREDIT_HISTORY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }



    //сервис временно не доступен, проверить xpath ассерта
    @Test
    public void testBlockCard() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CARD_BLOCK);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();
        DeeplinkPageObject.waitForCard();
        DeeplinkPageObject.clickCard();


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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(APPEAL);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(STATEMENTS_AND_REFERENCES);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

        String buttontext = "Блокировка карты";
        Assert.assertEquals(
                "Кнопка не привела в раздел блокировки карты ",
                DeeplinkPageObject.waitForCardBlock().getAttribute("text"),
                buttontext
        );
    }

    //Проверить , добавить правильные ассерты
    @Test
    public void testCreditStatements() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CREDIT_STATEMENTS);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(OPEN_DEPOSIT);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CARD_UNBLOCKING);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        DeeplinkPageObject.clickLink();
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
    public void testSberPay() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(SBER_PAY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(ACTIVATE_NOTIFICATION);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        DeeplinkPageObject.clickLink();

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
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(DEBIT_STATEMENTS);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(1000);
        try {
            OpenDialogAssistantPageObject.denyAssistantNotification();
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        DeeplinkPageObject.clickLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }
}

