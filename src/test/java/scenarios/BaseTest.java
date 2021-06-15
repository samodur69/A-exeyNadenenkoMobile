package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pageObjects.nativeObjects.NativeSigninPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import pageObjects.webObjects.WebPageObject;

public class BaseTest {

    private static AppiumDriver<MobileElement> appiumDriver;
    protected NativeSigninPage nativePo;
    protected WebPageObject webPo;

    public AppiumDriver<MobileElement> getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName", "appType", "deviceName", "browserName", "app", "newCommandTimeout"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName,
                      @Optional("") String app, @Optional("") String timeout) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, browserName, app, timeout);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName,
                                 String deviceName,
                                 String browserName,
                                 String app,
                                 String timeout) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");
        capabilities.setCapability("newCommandTimeout", timeout);

        try {
            appiumDriver = new AppiumDriver<>(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        appiumDriver.hideKeyboard();
    }

    private void setPageObject(String appType, AppiumDriver<MobileElement> appiumDriver) throws Exception {
        switch (appType) {
            case "native":
                nativePo = new NativeSigninPage(appiumDriver);
                break;
            case "web":
                webPo = new WebPageObject(appiumDriver);
                break;
            default:
                System.out.println("");
                break;
        }
    }
}
