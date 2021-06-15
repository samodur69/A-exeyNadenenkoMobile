package pageObjects.webObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.AbstractPageObject;

public class WebPageObject extends AbstractPageObject {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='rso']/div")
    private List<WebElement> searchResults;

    public WebPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
//        PageFactory.initElements(appiumDriver, this);
    }

    public WebPageObject searchTextFieldInput(String text) {
        sendKeys(searchField, text);
        appiumDriver.getKeyboard().sendKeys(Keys.ENTER);
        return new WebPageObject(appiumDriver);
    }

    public List<String> searchResultsHeaders() {
        return searchResults
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
