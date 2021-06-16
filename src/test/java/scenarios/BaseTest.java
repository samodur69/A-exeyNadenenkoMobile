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

    private static AppiumDriver appiumDriver;
    protected NativeSigninPage nativePo;
    protected WebPageObject webPo;

    public AppiumDriver getDriver() {
        return appiumDriver;
    }

    @Parameters({"platformName",
                    "appType",
                    "deviceName",
                    "udid",
                    "browserName",
                    "app",
                    "appPackage",
                    "appActivity",
                    "bundleId",
                    "newCommandTimeout"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName,
                      String appType,
                      @Optional("") String deviceName,
                      @Optional("") String udid,
                      @Optional("") String browserName,
                      @Optional("") String app,
                      @Optional("") String appPackage,
                      @Optional("") String appActivity,
                      @Optional("") String bundleId,
                      @Optional("") String timeout) throws Exception {
        System.out.println("Before: app type - " + appType);
        setAppiumDriver(platformName, deviceName, udid, browserName, app, appPackage, appActivity, bundleId, timeout);
        setPageObject(appType, appiumDriver);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName,
                                 String deviceName,
                                 String udid,
                                 String browserName,
                                 String app,
                                 String appPackage,
                                 String appActivity,
                                 String bundleId,
                                 String timeout) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("browserName", browserName);
        if (app.endsWith(".apk")) {
            capabilities.setCapability("app", (new File(app)).getAbsolutePath());
        }
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("chromedriverDisableBuildCheck", "true");
        capabilities.setCapability("newCommandTimeout", timeout);
//        if(platformName.equals("iOS")) {
//            capabilities.setCapability("automationName", "XCUITest");
//        }
        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        appiumDriver.hideKeyboard();
    }

    private void setPageObject(String appType, AppiumDriver appiumDriver) throws Exception {
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
