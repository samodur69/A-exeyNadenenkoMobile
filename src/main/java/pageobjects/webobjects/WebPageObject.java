package pageobjects.webobjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageObject {

    AppiumDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private static WebElement searchField;

    @FindBy(xpath = "//div[@id='rso']/div")
    private static List<WebElement> searchResults;

    public WebPageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchTextFieldInput(String text) {
        new WebDriverWait(driver, 10)
            .until(
            wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals("complete")
        );
        searchField.sendKeys(text + "\n");
    }

    public List<String> searchResultsHeaders() {
        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfAllElements(searchResults));
        new WebDriverWait(driver, 10)
            .until(
                wd -> ((JavascriptExecutor) wd)
                    .executeScript("return document.readyState").equals("complete")
            );
        return searchResults
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
