package dou.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static WebDriver driver;
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * explicity wait
     * @param webElement
     */
    protected static void waitForVisibilityOfElements(WebElement webElement){
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
