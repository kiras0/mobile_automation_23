
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class MobileTest extends TestBase{

    @Test
    void successfulSearchTest() throws MalformedURLException, InterruptedException {

        step("Search WiKi app for Java", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        });

        step("Check that result is not empty", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));

        step("Click on first link", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());

        step("Check Error is displayed", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible));
    }
}
