package selenide.steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import selenide.pages.DouPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

public class DouSteps {
   static DouPage douPage=new DouPage();
    @Given("^open Dou main page$")
    public static void launch(){
        Configuration.browser = "chrome";
        open("https://dou.ua/");
    }
    @After
    public void turnDown(){
        Selenide.closeWebDriver();
    }

    @Given("user is on Job tab")
    public static void userIsOnJobTab(){
        douPage.goToJobsTab();
    }
    @When("search for vacancies by query {string} in Kharkiv")
    public void searchForVacanciesByQueryKeywordInKharkiv(String keyword) {
        douPage.goToVacanciesSection();
        douPage.enterQueryInSearchField(keyword);
        douPage.chooseKharkiv();
    }
    @Then("^there are more than 0 vacancies$")
    public void thereAreMoreThanVacancies() {
        assertThat(douPage.getVacancyListSize(),not(0));
    }

    @When("go to Companies section")
    public void goToCompaniesSection() {
        douPage.goToCompaniesSection();
    }

    @Then("list of companies contains {int} companies")
    public void listOfCompaniesContainsCompanies(int companies){
        Assert.assertEquals(companies, douPage.getCompaniesListSize());
    }

    @Given("enter {string} in search field")
    public void enterInSearchField(String query) {
        douPage.enterQueryInGlobalSearchFiled(query);
    }

    @When("go to the first article link")
    public void goToTheFirstArticle() {
        String currentWindow= douPage.getCurrentWindowHandle();
        douPage.openFirstArticleInList();
        douPage.openNewWindow(currentWindow);
    }

    @Then("the Topics column contains {string} and {string}")
    public void theTopicsColumnContainsAnd(String tdd, String bdd) {
            for (String tag : douPage.getTextOfTopicsTags()) {
                assertThat(tag,anyOf(containsString(tdd),containsString(bdd)));
            }
        }
}