package pageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import pageObjects.webObjects.WebPageObject;
import setup.IPageObject;

// @DEPRECATED
public class PageObject implements IPageObject {
//    private AppiumDriver driver;
//    Object somePageObject; // it should be set of web page or EPAM Test App WebElements
//
//    public PageObject(String appType, AppiumDriver appiumDriver) throws Exception {
//        this.driver = appiumDriver;
//        System.out.println("Current app type: "+appType);
//        switch(appType){
//            case "web":
//                somePageObject = new WebPageObject(appiumDriver);
//                break;
//            case "native":
//                somePageObject = new NativePageObject(appiumDriver);
//                break;
//            default: throw new Exception("Can't create a page object for "+appType);
//        }
//    }
//
    @Override
    public void sendKeys(WebElement el, String text) {
        el.sendKeys(text);
    }

    @Override
    public void click(WebElement el) {
        el.click();
    }

    @Override
    public String getElementText(WebElement element) {
        return "";
    }

    //    @Override
//    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
//        // use reflection technique
//        Field field = somePageObject.getClass().getDeclaredField(weName);
//        field.setAccessible(true);
//        return (WebElement) field.get(somePageObject);
//
//    }
}
