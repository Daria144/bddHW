package dou.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;


public class DouMainPage extends BasePage {

    public DouMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     * tabs
     */
    @FindBy(xpath = "//a[@href=\"https://jobs.dou.ua/\"]")
    private WebElement jobsTab;
    /**
     * sections
     */
    @FindBy(xpath = "//li/a[@href=\"https://jobs.dou.ua/\" and @class=\"smi\"]")
    private WebElement vacanciesSection;
    @FindBy(xpath = "//a[@href=\"https://jobs.dou.ua/companies/\"]")
    private WebElement companiesSection;
    @FindBy(xpath = "//a[contains(@href,\"city=%D0%A5%D0%B0\")]")
    private static WebElement citiesListKharkiv;
    @FindBy(xpath = "//input[@class=\"job\"]")
    /**
     * input fields
     */
    private static WebElement inputField;
    @FindBy(xpath = "//input[@id=\"txtGlobalSearch\"]")
    private static WebElement globalSearchField;
    /**
     * first elements in list
     */
    @FindBy(xpath = "(//*[@class=\"gsc-expansionArea\"]//div[@class=\"gs-title\"]/a)[1]")
    private static WebElement firstArticle;

    /**
     * METHODS
     *
     * navigate to sections
     */
    public void goToJobsTab(){
        jobsTab.click();
    }
    public void goToVacanciesSection(){
        vacanciesSection.click();
    }
    public void goToCompaniesSection(){
        companiesSection.click();
    }

    /**
     * enter query in input fields
     */
    public void enterQueryInSearchField(String query){
        inputField.sendKeys(query);
        inputField.sendKeys(Keys.ENTER);
    }
    public void enterQueryInGlobalSearchFiled(String query){
        globalSearchField.sendKeys(query);
        globalSearchField.sendKeys(Keys.ENTER);
    }

    /**
     * get values from list of elements
     */
    public int getVacancyListSize(){
        List<WebElement> vacancyList = driver.findElements(By.xpath("//div[@id=\"vacancyListId\"]/ul/li"));
        return vacancyList.size();
    }
    public int getCompaniesListSize(){
        List<WebElement> companiesList = driver.findElements(By
                .xpath("//div[@id=\"companiesListId\"]/ul/li"));
        return  companiesList.size();
    }
    public String[] getTextOfTopicsTags(){
        int topicsSize=0;
        List<WebElement> topicsTags=driver.findElements(By.xpath("//*[@class=\"b-post-tags\"]/a"));
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
        waitForVisibilityOfElements(citiesListKharkiv);
        citiesListKharkiv.click();
    }
    public void openFirstArticleInList(){
        waitForVisibilityOfElements(firstArticle);
        firstArticle.click();
    }

    /**
     * @return current window handle
     */
    public String getCurrentWindowHandle(){
        return driver.getWindowHandle();
    }
    public void openNewWindow(String firstWindow){
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
           if(!firstWindow.equals(window)){
               driver.switchTo().window(window);
           }
        }
    }
}
