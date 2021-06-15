package pageObjects.nativeObjects;

import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pageObjects.AbstractPageObject;

public class NativeSigninPage extends AbstractPageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerNewButton;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement emailInput;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement pswInput;

    public NativeSigninPage(AppiumDriver driver) throws Exception {
        super(driver);
    }

    public NativeSignupPage navigateToRegistration() throws Exception {
        click(registerNewButton);
        return new NativeSignupPage(appiumDriver);
    }

    public NativeBudgetPage logIn(User user) throws Exception {
        sendKeys(emailInput, user.getEmail());
        sendKeys(pswInput, user.getPsw());
        click(signInButton);
        return new NativeBudgetPage(appiumDriver);
    }
}
