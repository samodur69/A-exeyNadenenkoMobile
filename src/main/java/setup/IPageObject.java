package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    void sendKeys(WebElement el, String text);

    void click(WebElement el);

    String getElementText(WebElement el);
}
