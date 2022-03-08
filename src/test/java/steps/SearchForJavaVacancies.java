package steps;

import dou.pages.JobsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

public class SearchForJavaVacancies {
    public static WebDriver driver;
    public static JobsPage jobsPage;
    @Before
    public static void launch(){
        System.setProperty("webdriver.chrome.driver", "/Users/daria_yatsenko/Downloads/chromedriver");
        driver = new ChromeDriver();
        jobsPage=new JobsPage(driver);
    }

    @After
    public void turnDown(){
        driver.quit();
    }

    @Given("user is on Job tab in Vacancies section")
    public void userIsOnJobTabInVacanciesSection() {
        driver.get("https://dou.ua/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        jobsPage.goToJobsTab();
        jobsPage.goToVacanciesSection();
    }

    @When("search for vacancies by query java in Kharkiv")
    public void searchForVacanciesByQueryJavaInKharkiv() {
        jobsPage.enterQueryInSearchField("java");
        jobsPage.chooseKharkiv();
    }

    @Then("there are more than 0 vacancies")
    public void thereAreMoreThanVacancies() {
        assertThat(jobsPage.getVacancyListSize(),not(0));
    }
}