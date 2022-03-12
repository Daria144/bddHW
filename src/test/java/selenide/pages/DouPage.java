package selenide.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Set;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class DouPage {

    /**
     * navigate to sections
     */
    public void goToJobsTab(){
        $(byXpath("//a[@href=\"https://jobs.dou.ua/\"]")).click();
    }
    public void goToVacanciesSection(){
       $(byXpath("//li/a[@href=\"https://jobs.dou.ua/\" and @class=\"smi\"]")).click();
    }
    public void goToCompaniesSection(){
        $(byXpath("//a[@href=\"https://jobs.dou.ua/companies/\"]")).click();
    }

    /**
     * enter query in input fields
     */
    public void enterQueryInSearchField(String query){
        $(byXpath("//input[@class=\"job\"]")).setValue(query).pressEnter();
    }
    public void enterQueryInGlobalSearchFiled(String query){
        $(byXpath("//input[@id=\"txtGlobalSearch\"]")).setValue(query).pressEnter();
    }

    /**
     * get values from list of elements
     */
    public int getVacancyListSize(){
        return $$(byXpath("//div[@id=\"vacancyListId\"]/ul/li")).size();
    }
    public int getCompaniesListSize(){
        return $$(byXpath("//div[@id=\"companiesListId\"]/ul/li")).size();
    }
    public String[] getTextOfTopicsTags(){
        int topicsSize=0;
        ElementsCollection topicsTags = $$(byXpath("//*[@class=\"b-post-tags\"]/a"));
        topicsSize=topicsTags.size();
        String[] textOfTags= new String[topicsSize];
        for (WebElement tag : topicsTags) {
            textOfTags[topicsSize-1]=tag.getText();
            topicsSize--;
        }
        return textOfTags;
    }


    /**
     * click on some elements
     */
    public void chooseKharkiv(){
        $(By.xpath("//a[contains(@href,\"city=%D0%A5%D0%B0\")]")).click();
    }
    public void openFirstArticleInList(){
        $(byXpath("(//*[@class=\"gsc-expansionArea\"]//div[@class=\"gs-title\"]/a)[1]")).click();
    }

    /**
     * @return current window handle
     */
    public String getCurrentWindowHandle(){
        return getWebDriver().getWindowHandle();
    }
    public void openNewWindow(String firstWindow){
        Set<String> windows = getWebDriver().getWindowHandles();
        for (String window : windows) {
           if(!firstWindow.equals(window)){
               Selenide.switchTo().window(window);
           }
        }
    }
}
