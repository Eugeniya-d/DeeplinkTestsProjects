package tests;

import lib.CoreTestCase;
import org.junit.Assert;
import org.junit.Test;
import ui.*;



public class DeeplinkTests extends CoreTestCase {
    private static final String
    CHANGE_PIN = "legacy-android-app://ru.sberbankmobile_alpha/digitalpin/setup?source=chatbot&internal_source=audiohelper",
    CARD_REISSUE = "legacy-android-app://ru.sberbankmobile_alpha/products/card/reissue?internal_source=audiohelper",
    CARD_BLOCK = "legacy-android-app://ru.sberbankmobile_alpha/blockcard/add?internal_source=audiohelper",
    CARD_UNBLOCKING = "android-app://ru.sberbankmobile_alpha/products/card/unblock?internal_source=audiohelper",
    DEBIT_CARD_ORDER = "legacy-android-app://ru.sberbankmobile_alpha/mdcard/mdcardrequest?internal_source=audiohelper",
    CREDIT_CARD_ORDER = "legacy-android-app://ru.sberbankmobile_alpha/mdcard/mdcardrequest?internal_source=audiohelper",
    CARD_VISIBILITY = "android-app://ru.sberbankmobile_alpha/visibilityRecovery?internal_source=audiohelper",
    SBER_PAY = "android-app://ru.sberbankmobile_alpha/sberpay/nfc/wallet?internal_source=audiohelper",
    OPEN_DEPOSIT = "android-app://ru.sberbankmobile_alpha/products/deposit?action=create&internal_source=audiohelper",
    ACTIVATE_NOTIFICATION = "android-app://ru.sberbankmobile_alpha/mobilebank/activation?internal_source=audiohelper",
    NOTIFICATION_LIST = "android-app://ru.sberbankmobile_alpha/pushes/notificationlist?internal_source=audiohelper",
    PUSHES = "legacy-android-app://ru.sberbankmobile_alpha/pushes/mobilebank?internal_source=audiohelper",
    POTREB_LOAN = "android-app://ru.sberbankmobile_alpha/consumerLoan?internal_source=audiohelper",
    AUTO_LOAN = "legacy-android-app://ru.sberbankmobile_alpha/carloans/carloanrequest?internal_source=audiohelper",
    REFIN_LOAN = "android-app://ru.sberbankmobile_alpha/refinloan?internal_source=audiohelper",
    CREDIT_CAPACITY = "android-app://ru.sberbankmobile_alpha/creditcapacity/calculatecp?internal_source=audiohelper",
    CREDIT_HISTORY = "android-app://ru.sberbankmobile_alpha/creditreportservice?internal_source=audiohelper",
    AUTO_PAYMENTS = "android-app://ru.sberbankmobile_alpha/payments/auto_payments?internal_source=audiohelper",
    TARIFFS = "",
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



    Thread.sleep(5000);
    DeeplinkPageObject.clickLink();

    String buttontext = "Главный";
    Assert.assertEquals(
            "Ссылка привела не на главный экран",
            MainScreenPageObject.waitForHomeButton().getAttribute("text"),
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

        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();
        DeeplinkPageObject.denyCallButton();
    }

//не переходит по ссылке, хоть она и кликабельна
   @Test
    public void testChangePin() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CHANGE_PIN);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();


       Thread.sleep(5000);
       DeeplinkPageObject.clickLink();
       DeeplinkPageObject.denyCallButton();
    }

    //попробовать на клиенте с картами и добавить ассерт
    @Test
    public void testCardVisibility() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(CARD_VISIBILITY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();



        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();
        DeeplinkPageObject.backToAssistant();
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




        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    @Test
    public void testHistory() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);
        
        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(HISTORY);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }

    //ссылка-птичка
    @Test
    public void testPushes() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(PUSHES);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();

        String buttontext = "Тип операции";
        Assert.assertEquals(
                "Кнопка не привела в раздел история операций",
                DeeplinkPageObject.waitForOperationTypePresent().getAttribute("text"),
                buttontext
        );
    }


    @Test
    public void testOpenDeposit() throws InterruptedException {
        OpenDialogAssistantPageObject OpenDialogAssistantPageObject = new OpenDialogAssistantPageObject(driver);
        DeeplinkPageObject DeeplinkPageObject = new DeeplinkPageObject(driver);

        OpenDialogAssistantPageObject.clickInputLine();
        OpenDialogAssistantPageObject.inputText(OPEN_DEPOSIT);
        OpenDialogAssistantPageObject.sendMessage();
        OpenDialogAssistantPageObject.sendMessage();

        Thread.sleep(5000);
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

        Thread.sleep(5000);
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

        Thread.sleep(5000);
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

        Thread.sleep(5000);
        DeeplinkPageObject.clickLink();

        String buttontext = "Уведомления";
        Assert.assertEquals(
                "Кнопка не привела в раздел уведомления",
                DeeplinkPageObject.waitForNotificationTitle().getAttribute("text"),
                buttontext
        );
    }
}

