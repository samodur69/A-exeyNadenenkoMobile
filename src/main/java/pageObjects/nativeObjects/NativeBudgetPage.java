package pageObjects.nativeObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AbstractPageObject;

public class NativeBudgetPage extends AbstractPageObject {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
        "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/" +
        "android.view.ViewGroup/android.widget.TextView")
    WebElement title;

    public NativeBudgetPage(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
    }

    public String getPageTitle() {
        return getElementText(title);
    }
}
