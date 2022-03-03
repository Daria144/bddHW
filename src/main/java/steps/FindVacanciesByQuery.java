package steps;

import dou.configuration.ConfigProperties;
import dou.pages.JobsPage;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindVacanciesByQuery {
    public static WebDriver driver;

    @Given("user is on Job tab in Vacancies section")
    public void userIsOnVacanciesSection(){
        System.setProperty(ConfigProperties.getProperty("chromeKey"), ConfigProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigProperties.getProperty("mainPage"));
        JobsPage.goToJobsTab();
        JobsPage.goToVacanciesSection();
    }
    @When("search for vacancies by query java in Kharkiv")
    public void SearchForVacanciesInKharkiv(){
        JobsPage.enterQueryInSearchField("java");
        JobsPage.chooseKharkiv();
    }
    @Then("there are more than 0 vacancies")
    public void searchResultIsNotEmpty(){
        assertThat(JobsPage.getVacancyListSize(),not(0));
    }
}
