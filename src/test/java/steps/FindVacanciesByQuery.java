package steps;

import dou.pages.JobsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindVacanciesByQuery {

    @Given("^user is on Job tab in Vacancies section$")
    public void user_is_on_job_tab_in_vacancies_section(){
        open("https://dou.ua/");
        JobsPage.goToJobsTab();
        JobsPage.goToVacanciesSection();
    }
    @When("search for vacancies by query java in Kharkiv")
    public void search_for_vacancies_by_query_java_in_kharkiv(){
        JobsPage.enterQueryInSearchField("java");
        JobsPage.chooseKharkiv();
    }
    @Then("there are more than 0 vacancies")
    public void there_are_more_than_vacancies(){
        assertThat(JobsPage.getVacancyListSize(),not(0));
    }
}
