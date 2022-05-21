package org.example;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("http://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим по ссылке репозитория {repository}")
    public void clickOnRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue с номером {issueNumber}")
    public void shouldSeeIssueWithNumber(String issueNumber) {
        $(withText(issueNumber)).shouldBe(Condition.visible);
    }

}
