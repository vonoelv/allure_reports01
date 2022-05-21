package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideOnlyTest {

    public static final String REPOSITORY = "vonoelv/hw6_parametrizedTest";
    public static final String ISSUE_NUMBER = "#1";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("http://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $(partialLinkText("Issues")).click();
        $(withText(ISSUE_NUMBER)).shouldBe(Condition.visible);
    }
}
