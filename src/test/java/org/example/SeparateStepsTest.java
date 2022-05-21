package org.example;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SeparateStepsTest {

    public static final String REPOSITORY = "vonoelv/hw6_parametrizedTest";
    public static final String ISSUE_NUMBER = "#1";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps webSteps = new WebSteps();
        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.clickOnRepositoryLink(REPOSITORY);
        webSteps.openIssuesTab();
        webSteps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
