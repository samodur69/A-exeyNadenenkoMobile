package pageObjects.nativeObjects;

import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class NativeSignupPage extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    WebElement emailField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    WebElement usernameField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    WebElement passwordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    WebElement confirmPasswordField;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    WebElement registerNewAccBtn;
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    WebElement cancelBtn;

    public NativeSignupPage(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public NativeSigninPage createAccount(User user) throws Exception {
        sendKeys(emailField, user.getEmail());
        sendKeys(usernameField, user.getUsername());
        sendKeys(passwordField, user.getPsw());
        sendKeys(confirmPasswordField, user.getPsw());
        click(registerNewAccBtn);
        return new NativeSigninPage(appiumDriver);
    }
}
