package dou.steps;
import dou.pages.DouMainPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

public class DouSteps {
    public static WebDriver driver;
    public static DouMainPage douPage;
    @Given("^open Dou main page$")
    public static void launch(){
        System.setProperty("webdriver.chrome.driver", "/Users/daria_yatsenko/IdeaProjects/bddHW/src/test/java/dou/driver/chromedriver");
        driver = new ChromeDriver();
        douPage=new DouMainPage(driver);
        driver.get("https://dou.ua/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void turnDown(){
        driver.quit();
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