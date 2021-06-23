package pageobjects.nativeobjects;

import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pageobjects.AbstractPageObject;

public class NativeSignupPage extends AbstractPageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccBtn;

    public NativeSignupPage(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public NativeSigninPage createAccount(User user) throws Exception {
        sendKeys(emailField, user.getEmail());
        sendKeys(usernameField, user.getUsername());
        sendKeys(passwordField, user.getPsw());
        sendKeys(confirmPasswordField, user.getPsw());

        click(registerNewAccBtn);
//        click(registerNewAccBtn);
        return new NativeSigninPage(appiumDriver);
    }
}
