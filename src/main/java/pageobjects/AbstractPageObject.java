package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.IPageObject;

public class AbstractPageObject implements IPageObject {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait wait;

    public AbstractPageObject(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 20);
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    @Override
    public void sendKeys(WebElement el, String text) {
        // commented Method used only for local test with my hardware
        //        appiumDriver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOf(el));
        el.sendKeys(text);
    }

    @Override
    public void click(WebElement el) {
        // commented Method used only for local test with my hardware
        //        appiumDriver.hideKeyboard();
        wait.until(ExpectedConditions.elementToBeClickable(el));
//        el.submit();
        el.click();
    }

    @Override
    public String getElementText(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        return el.getText();
    }
}
