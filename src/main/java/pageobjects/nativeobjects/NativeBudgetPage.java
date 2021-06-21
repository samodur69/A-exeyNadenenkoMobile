package pageobjects.nativeobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pageobjects.AbstractPageObject;

public class NativeBudgetPage extends AbstractPageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
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
