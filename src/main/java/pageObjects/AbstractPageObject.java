package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.IPageObject;

public class AbstractPageObject implements IPageObject {

    protected AppiumDriver<MobileElement> appiumDriver;
    protected WebDriverWait wait;

    public AbstractPageObject(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 20);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void openUrlInBrowser(String url) {
        appiumDriver.get(url);
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState")
                .equals("complete"));
    }

    @Override
    public void sendKeys(WebElement el, String text) {
        appiumDriver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys(text);
    }

    @Override
    public void click(WebElement el) {
        appiumDriver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(el));
        el.click();
    }

    @Override
    public String getElementText(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        return el.getText();
    }
}
