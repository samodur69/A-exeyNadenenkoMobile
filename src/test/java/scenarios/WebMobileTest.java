package scenarios;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import setup.TestDataProvider;

public class WebMobileTest extends BaseTest {

    @Test(groups = {"web"},
          dataProviderClass = TestDataProvider.class,
          dataProvider = "webData")
    public void searchEpamInMobileBrowser(String url, String request) {
        getDriver().get(url);

        assertThat(
            (int) getWebPo()
                .searchTextFieldInput(request)
                .searchResultsHeaders()
                .stream()
                .filter(s -> s.contains(request)).count()
        ).isGreaterThan(0)
         .as("No relevant results found");
    }
}
