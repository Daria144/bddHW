package dou.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;

public class JobsPage {
    public static void goToJobsTab(){
        WebElement jobsTab=$(By.xpath("//a[@class=\"sel\"]"));
        jobsTab.click();
    }
    public static void goToVacanciesSection(){
        WebElement vacanciesSection=$(By.xpath("//li/a[@href=\"https://jobs.dou.ua/\" and @class=\"smi\"]"));
        vacanciesSection.click();
    }
    public static void chooseKharkiv(){
        WebElement citiesListKharkiv=$(By.xpath("//a[contains(@href,\"city=%D0%A5%D0%B0\")]"));
        citiesListKharkiv.click();
    }
    public static void enterQueryInSearchField(String query){
        WebElement inputField = $(By.xpath("//input[@class=\"job\"]"));
        inputField.sendKeys(query);
        inputField.sendKeys(Keys.ENTER);
    }
    public static int getVacancyListSize(){
        ArrayList<WebElement> vacancyList= (ArrayList<WebElement>) $(By.xpath("//div[@id=\"vacancyListId\"]/ul/li"));
        return vacancyList.size();
    }
}
