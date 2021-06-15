package scenarios;

import java.util.regex.Pattern;
import org.testng.annotations.Test;
import setup.BaseTest;

public class MyWebMobileTest extends BaseTest {

    @Test(groups = {"web"})
    public void searchEpamInMobileBrowser() {
        webPo.openUrlInBrowser("https://google.com");
        Pattern p = Pattern.compile("(.EPAM.)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //        assertTrue(getWebPo()
//            .searchTextFieldInput("EPAM")
//            .searchResultsHeaders()
//            .contains(), "");
    }
}
