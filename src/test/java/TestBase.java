import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void beforeAll(){
        Configuration.browser = BrowserStackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }
    @BeforeEach
    void beforeEach(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }
    @AfterEach
    void addAttachment(){
        String sessionId = sessionId().toString();
        Attachments.pageSource();
        closeWebDriver();
        Attachments.addVideo(sessionId);
    }
}
