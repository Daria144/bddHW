package dou.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class JobsPage extends BasePage{
    public JobsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@class=\"sel\"]")
    private static WebElement jobsTab;
    @FindBy(xpath = "//li/a[@href=\"https://jobs.dou.ua/\" and @class=\"smi\"]")
    private static WebElement vacanciesSection;
    @FindBy(xpath = "//input[@class=\"job\"]")
    private static WebElement inputField;
    @FindBy(xpath = "//a[contains(@href,\"city=%D0%A5%D0%B0\")]")
    private static WebElement citiesListKharkiv;

    public static void goToJobsTab(){
        jobsTab.click();
    }
    public static void goToVacanciesSection(){
        vacanciesSection.click();
    }
    public static void chooseKharkiv(){
        citiesListKharkiv.click();
    }
    public static void enterQueryInSearchField(String query){
        inputField.sendKeys(query);
        inputField.sendKeys(Keys.ENTER);
    }
    public static int getVacancyListSize(){
        ArrayList<WebElement> vacancyList= (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id=\"vacancyListId\"]/ul/li"));
        return vacancyList.size();
    }
}
