package dou.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class JobsPage extends BasePage {



    @FindBy(xpath = "//a[@href=\"https://jobs.dou.ua/\"]")
    private WebElement jobsTab;
    @FindBy(xpath = "//li/a[@href=\"https://jobs.dou.ua/\" and @class=\"smi\"]")
    private WebElement vacanciesSection;
    @FindBy(xpath = "//a[contains(@href,\"city=%D0%A5%D0%B0\")]")
    private static WebElement citiesListKharkiv;
    @FindBy(xpath = "//input[@class=\"job\"]")
    private static WebElement inputField;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void goToJobsTab(){
        jobsTab.click();
    }
    public void goToVacanciesSection(){
        vacanciesSection.click();
    }
    public void chooseKharkiv(){
        citiesListKharkiv.click();
    }
    public void enterQueryInSearchField(String query){
        inputField.sendKeys(query);
        inputField.sendKeys(Keys.ENTER);
    }
    public int getVacancyListSize(){
        List<WebElement> vacancyList = driver.findElements(By.xpath("//div[@id=\"vacancyListId\"]/ul/li"));
        return vacancyList.size();
    }
}
