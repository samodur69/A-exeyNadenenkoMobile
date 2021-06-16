package scenarios;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import setup.TestDataProvider;

public class WebMobileTest extends BaseTest {

    @Test(groups = {"web"},
          dataProviderClass = TestDataProvider.class,
          dataProvider = "webData")
    public void searchEpamInMobileBrowser(String url, String request) {
        getDriver().get(url);
        assertTrue(
            webPo
                .searchTextFieldInput(request)
                .searchResultsHeaders()
                .size() > 0,
            "No revelant results");
    }
}
